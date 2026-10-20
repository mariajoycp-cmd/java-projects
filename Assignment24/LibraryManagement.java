import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class LibraryManagement extends JFrame {

    JTextField id, title, author, price;
    JTextArea output;
    Connection con;

    LibraryManagement() {
        setTitle("Library Management System");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jdbc_demo",
                "root",
                "NewPass123"
            );

            JOptionPane.showMessageDialog(
                this, "Database connected successfully!"
            );

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                this,
                "Connection failed:\n" + e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE
            );
            e.printStackTrace();
        }

        id = new JTextField(10);
        title = new JTextField(10);
        author = new JTextField(10);
        price = new JTextField(10);

        output = new JTextArea(12, 40);
        output.setEditable(false);

        add(new JLabel("Book ID:"));
        add(id);
        add(new JLabel("Title:"));
        add(title);
        add(new JLabel("Author:"));
        add(author);
        add(new JLabel("Price:"));
        add(price);

        JButton insert = new JButton("Add Book");
        JButton display = new JButton("Display Books");
        JButton update = new JButton("Update Book");
        JButton delete = new JButton("Delete Book");

        add(insert);
        add(display);
        add(update);
        add(delete);
        add(new JScrollPane(output));

        // Add Book
        insert.addActionListener(e ->
            execute("INSERT INTO Books VALUES (?, ?, ?, ?)", 1)
        );

        // Update Book
        update.addActionListener(e ->
            execute(
                "UPDATE Books SET title=?, author=?, price=? WHERE book_id=?",
                2
            )
        );

        // Delete Book
        delete.addActionListener(e -> {
            if (con == null) {
                showError(new Exception("Database is not connected."));
                return;
            }

            try (PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM Books WHERE book_id=?")) {

                ps.setInt(1, Integer.parseInt(id.getText().trim()));

                int rows = ps.executeUpdate();

                output.setText(rows > 0
                    ? "Book deleted successfully."
                    : "Book not found.");

            } catch (Exception ex) {
                showError(ex);
            }
        });

        // Display Books
        display.addActionListener(e -> {
            if (con == null) {
                showError(new Exception("Database is not connected."));
                return;
            }

            output.setText("");

            try (Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery("SELECT * FROM Books")) {

                while (rs.next()) {
                    output.append(
                        "ID: " + rs.getInt("book_id") +
                        ", Title: " + rs.getString("title") +
                        ", Author: " + rs.getString("author") +
                        ", Price: " + rs.getDouble("price") + "\n"
                    );
                }

                if (output.getText().isEmpty()) {
                    output.setText("No books found.");
                }

            } catch (Exception ex) {
                showError(ex);
            }
        });

        setVisible(true);
    }

    void execute(String query, int operation) {
        if (con == null) {
            showError(new Exception("Database is not connected."));
            return;
        }

        try (PreparedStatement ps = con.prepareStatement(query)) {

            if (operation == 1) {
                // Insert book
                ps.setInt(1, Integer.parseInt(id.getText().trim()));
                ps.setString(2, title.getText().trim());
                ps.setString(3, author.getText().trim());
                ps.setDouble(4, Double.parseDouble(price.getText().trim()));

            } else {
                // Update book
                ps.setString(1, title.getText().trim());
                ps.setString(2, author.getText().trim());
                ps.setDouble(3, Double.parseDouble(price.getText().trim()));
                ps.setInt(4, Integer.parseInt(id.getText().trim()));
            }

            int rows = ps.executeUpdate();

            output.setText(rows > 0
                ? "Operation completed successfully."
                : "No records affected.");

        } catch (Exception ex) {
            showError(ex);
        }
    }

    void showError(Exception e) {
        JOptionPane.showMessageDialog(
            this,
            e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LibraryManagement());
    }
}
