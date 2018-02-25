<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"  %>
<!DOCTYPE html>
<html>
<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/add-student-style.css">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Information</title>
    </head>
    <body>
    <div id="wrapper">
<div id="header">
<h2> Uhela University</h2>
</div>
</div>
        
        <br />

        <form action="StudentServlet" method="POST">
            <table>
                <tr>
                    <td>Student ID:</td>
                    <td><input type="text" name="id" value="${student.studentID}"/></td>
                </tr>
                <tr>
                    <td>First name:</td>
                    <td><input type="text" name="firstname" value="${student.firstName}"/></td>
                </tr>
                <tr>
                    <td>Last name:</td>
                    <td><input type="text" name="lastname" value="${student.lastName}"/></td>
                </tr>
                <tr>
                    <td>Address:</td>
                    <td><input type="text" name="address" value="${student.address}" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="Submit" name="operation" value="Add" />
                    <input type="Submit" name="operation" value="Edit" />
                    <input type="Submit" name="operation" value="Delete" />
                    <input type="Submit" name="operation" value="Search" /></td>
                </tr>                
            </table>
        </form>
        <table border="1">
            <th>Student ID</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Address</th>
            <c:forEach items="${allStudent}" var="student">
                <tr>
                    <td>${student.studentID}</td>
                    <td>${student.firstName}</td>
                    <td>${student.lastName}</td>
                    <td>${student.address}</td>
                </tr>
            </c:forEach>                 
        </table>
        <br>
        <a href="Logout">Logout</a>
    </body>
</html>
