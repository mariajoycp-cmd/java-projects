import library.Book;

public class Main {
    public static void main(String[] args) {

        Book b = new Book(
            1001,
            "Java Programming",
            "James Gosling",
            599.00
        );

        b.displayBook();
    }
}