<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<title>Delete Employee</title>
</head>
<body>
<h2>Delete Employee</h2>

<form action="deleteEmployee.jsp" method="post">
Employee ID:
<input type="number" name="employee_id" required>
<input type="submit" value="Delete Employee">
</form>

<%
if ("POST".equalsIgnoreCase(request.getMethod())) {
String id = request.getParameter("employee_id");

try {
Class.forName("com.mysql.cj.jdbc.Driver");

try (Connection con = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/employeeDB",
"root", "Anvi@1234")) {

String sql = "DELETE FROM employees WHERE employee_id=?";

try (PreparedStatement ps = con.prepareStatement(sql)) {
ps.setInt(1, Integer.parseInt(id));

int rows = ps.executeUpdate();

if (rows > 0) {
out.println("<p>Employee deleted successfully!</p>");
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
