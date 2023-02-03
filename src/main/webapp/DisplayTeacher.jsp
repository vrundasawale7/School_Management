<%@page import="School.Teacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
a{
align:right;
color:white;
background-color: black;
text-decoration:none;
padding: 20px;
}
div{
     text-align: right;
}
</style>
</head>
<body>
<% Teacher t=(Teacher)session.getAttribute("sundaydata"); %>

<table align="center" border="2" cellpaddint="30px" cellspacing="5px">
<th>Id</th>
<th>Name</th>
<th>Subject</th>
<th>Salary</th>
<tr>
<td><%= t.getId() %></td>
<td><%= t.getName() %></td>
<td><%= t.getSub() %></td>
<td><%= t.getSal() %></td>
</tr>
</table>
<div> <a href="crudTeacher.html">Main Menu</a></div>
</body>
</html>
</body>
</html>