<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<title>View Employees</title>
<style>
table {
    border-collapse: collapse;
    width: 90%;
    margin: auto;
}
th, td {
    border: 1px solid black;
    padding: 10px;
    text-align: center;
}
th {
    background: #1769aa;
    color: white;
}
body {
    font-family: Arial;
    text-align: center;
}
</style>
</head>
<body>
<h2>Employee Records</h2>
<table>
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Department</th>
    <th>Salary</th>
    <th>Email</th>
</tr>
<%
try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    try (
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/employeeDB",
            "root",
            "NewPass123"
        );

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(
            "SELECT * FROM employees ORDER BY employee_id"
        )
    ) {

        while (rs.next()) {
%>
<tr>
    <td><%= rs.getInt("employee_id") %></td>
    <td><%= rs.getString("name") %></td>
    <td><%= rs.getString("department") %></td>
    <td><%= rs.getBigDecimal("salary") %></td>
    <td><%= rs.getString("email") %></td>
</tr>
<%
        }
    }

} catch (Exception e) {
    out.println(
        "<tr><td colspan='5'>Error: "
        + e.getMessage()
        + "</td></tr>"
    );
}
%>
</table>
<br>
<a href="index.jsp">Back to Home</a>
</body>
</html>
