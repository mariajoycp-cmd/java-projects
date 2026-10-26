<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<title>Add Employee</title>
</head>
<body>
<h2>Add Employee</h2>

<form action="addEmployee.jsp" method="post">
Employee ID:
<input type="number" name="employee_id" required><br><br>

Name:
<input type="text" name="name" required><br><br>

Department:
<input type="text" name="department" required><br><br>

Salary:
<input type="number" name="salary" min="0" step="0.01" required><br><br>

Email:
<input type="email" name="email" required><br><br>

<input type="submit" value="Add Employee">
</form>

<%
if ("POST".equalsIgnoreCase(request.getMethod())) {
String id = request.getParameter("employee_id");
String name = request.getParameter("name");
String department = request.getParameter("department");
String salary = request.getParameter("salary");
String email = request.getParameter("email");

try {
Class.forName("com.mysql.cj.jdbc.Driver");

try (Connection con = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/employeeDB",
"root", "YOUR_MYSQL_PASSWORD")) {

String sql = "INSERT INTO employees VALUES (?, ?, ?, ?, ?)";

try (PreparedStatement ps = con.prepareStatement(sql)) {
ps.setInt(1, Integer.parseInt(id));
ps.setString(2, name);
ps.setString(3, department);
ps.setBigDecimal(4, new java.math.BigDecimal(salary));
ps.setString(5, email);

ps.executeUpdate();
out.println("<p>Employee added successfully!</p>");
}
}
} catch (Exception e) {
out.println("<p>Error: " + e.getMessage() + "</p>");
}
}
%>

<br><a href="index.jsp">Back to Home</a>
</body>
</html>
