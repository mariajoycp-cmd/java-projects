<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<title>Delete Patient</title>
</head>
<body>
<h2>Delete Patient Record</h2>

<form action="deletePatient.jsp" method="post">
Patient ID:
<input type="number" name="patient_id" required>
<input type="submit" value="Delete Patient">
</form>

<%
if ("POST".equalsIgnoreCase(request.getMethod())) {
String id = request.getParameter("patient_id");

try {
Class.forName("com.mysql.cj.jdbc.Driver");

try (Connection con = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/hospitalDB",
"root", "NewPass123")) {

String sql = "DELETE FROM patients WHERE patient_id=?";

try (PreparedStatement ps = con.prepareStatement(sql)) {
ps.setInt(1, Integer.parseInt(id));

int rows = ps.executeUpdate();

if (rows > 0) {
out.println("<p>Patient deleted successfully!</p>");
} else {
out.println("<p>Patient ID not found.</p>");
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

