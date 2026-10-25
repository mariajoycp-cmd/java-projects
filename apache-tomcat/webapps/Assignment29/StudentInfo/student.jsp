<!DOCTYPE html>
<html>
<head>
    <title>Student Information</title>
</head>
<body>
<h2>Enter Student Information</h2>
<form action="studentResult.jsp" method="post">
    <label>Name:</label>
    <input type="text" name="name" required>
    <br><br>

    <label>PRN:</label>
    <input type="text" name="prn" required>
    <br><br>

    <label>Semester:</label>
    <input type="text" name="semester" required>
    <br><br>

    <label>Branch:</label>
    <input type="text" name="branch" required>
    <br><br>

    <label>Email:</label>
    <input type="email" name="email" required>
    <br><br>

    <input type="submit" value="Submit">
</form>
