<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<title>Update Patient</title>
</head>
<body>
<h2>Update Patient Details</h2>

<form action="updatePatient.jsp" method="post">
Patient ID:
<input type="number" name="patient_id" required><br><br>

New Name:
<input type="text" name="name" required><br><br>

New Age:
<input type="number" name="age" min="1" max="150" required><br><br>

New Disease:
<input type="text" name="disease"><br><br>

Treatment Status:
<select name="treatment_status">
<option value="Under Treatment">Under Treatment</option>
<option value="Recovered">Recovered</option>
<option value="Discharged">Discharged</option>
</select><br><br>

<input type="submit" value="Update Patient">
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

String sql = "UPDATE patients SET name=?, age=?, disease=?, "
+ "treatment_status=? WHERE patient_id=?";

try (PreparedStatement ps = con.prepareStatement(sql)) {
ps.setString(1, name);
ps.setInt(2, Integer.parseInt(age));
ps.setString(3, disease);
ps.setString(4, status);
ps.setInt(5, Integer.parseInt(id));

int rows = ps.executeUpdate();

if (rows > 0) {
out.println("<p>Patient updated successfully!</p>");
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
