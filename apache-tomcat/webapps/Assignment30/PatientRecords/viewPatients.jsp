<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<title>View Patients</title>
<style>
table {
border-collapse: collapse;
width: 90%;
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
</style>
</head>
<body>
<h2>All Patient Records</h2>

<table>
<tr>
<th>Patient ID</th>
<th>Name</th>
<th>Age</th>
<th>Disease</th>
<th>Treatment Status</th>
</tr>

<%
try {
Class.forName("com.mysql.cj.jdbc.Driver");

try (Connection con = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/hospitalDB",
"root", "NewPass123");
Statement st = con.createStatement();
ResultSet rs = st.executeQuery(
"SELECT * FROM patients ORDER BY patient_id")) {

while (rs.next()) {
%>
<tr>
<td><%= rs.getInt("patient_id") %></td>
<td><%= rs.getString("name") %></td>
<td><%= rs.getInt("age") %></td>
<td><%= rs.getString("disease") %></td>
<td><%= rs.getString("treatment_status") %></td>
</tr>
<%
}
}
} catch (Exception e) {
out.println("<tr><td colspan='5'>Error: "
+ e.getMessage() + "</td></tr>");
}
%>
</table>

<br><a href="index.jsp">Back to Home</a>
</body>
</html>
