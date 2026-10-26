<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<title>Update Employee</title>
</head>
<body>
<h2>Update Employee Details</h2>

<form action="updateEmployee.jsp" method="post">
Employee ID:
<input type="number" name="employee_id" required><br><br>

New Name:
<input type="text" name="name" required><br><br>

New Department:
<input type="text" name="department" required><br><br>

New Salary:
<input type="number" name="salary" min="0" step="0.01" required><br><br>

New Email:
<input type="email" name="email" required><br><br>

<input type="submit" value="Update Employee">
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
"root", "NewPass123")) {

String sql = "UPDATE employees SET name=?, department=?, "
+ "salary=?, email=? WHERE employee_id=?";

try (PreparedStatement ps = con.prepareStatement(sql)) {
ps.setString(1, name);
ps.setString(2, department);
ps.setBigDecimal(3, new java.math.BigDecimal(salary));
ps.setString(4, email);
ps.setInt(5, Integer.parseInt(id));

int rows = ps.executeUpdate();

if (rows > 0) {
out.println("<p>Employee updated successfully!</p>");
} else {
out.println("<p>Employee ID not found.</p>");
}
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
