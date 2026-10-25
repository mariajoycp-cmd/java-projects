<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<title>Add Patient</title>
</head>
<body>
<h2>Add Patient Details</h2>

<form action="addPatient.jsp" method="post">
Patient ID:
<input type="number" name="patient_id" required><br><br>

Name:
<input type="text" name="name" required><br><br>

Age:
<input type="number" name="age" min="1" max="150" required><br><br>

Disease:
<input type="text" name="disease"><br><br>

Treatment Status:
<select name="treatment_status">
<option value="Under Treatment">Under Treatment</option>
<option value="Recovered">Recovered</option>
<option value="Discharged">Discharged</option>
</select><br><br>

<input type="submit" value="Add Patient">
</form>

<%
if ("POST".equalsIgnoreCase(request.getMethod())) {
String id = request.getParameter("patient_id");
String name = request.getParameter("name");
String age = request.getParameter("age");
String disease = request.getParameter("disease");
String status = request.getParameter("treatment_status");

try {
Class.forName("com.mysql.cj.jdbc.Driver");

try (Connection con = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/hospitalDB",
"root", "NewPass123")) {

String sql = "INSERT INTO patients VALUES (?, ?, ?, ?, ?)";

try (PreparedStatement ps = con.prepareStatement(sql)) {
ps.setInt(1, Integer.parseInt(id));
ps.setString(2, name);
ps.setInt(3, Integer.parseInt(age));
ps.setString(4, disease);
ps.setString(5, status);

ps.executeUpdate();
out.println("<p>Patient added successfully!</p>");
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
