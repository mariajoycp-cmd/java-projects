<%@ page contentType="text/html;charset=UTF-8" %> 
Student Information
<%
    String name = request.getParameter("name");
    String prn = request.getParameter("prn");
    String semester = request.getParameter("semester");
    String branch = request.getParameter("branch");
    String email = request.getParameter("email");
%>

<p>Name: <%= name %></p>
<p>PRN: <%= prn %></p>
<p>Semester: <%= semester %></p>
<p>Branch: <%= branch %></p>
<p>Email: <%= email %></p>

<br>
<a href="student.jsp">Go Back</a>
