<%@page import="School.Student"%>
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
    text-align:right;
}
</style>
</head>
<body>
  <% Student s=(Student) session.getAttribute("displaydata"); %>

  <table border="2" cellspacint="5px" cellpadding="10px" align="center">
  <th>Id</th>
  <th>Name</th>
  <th>Stream</th>
  <th>Fees</th>
  <tr>
     <td><%= s.getId() %></td>
     <td><%= s.getName() %></td>
     <td><%= s.getStream() %></td>
     <td><%= s.getFees() %></td>
  </tr>
  </table>
  <div><a href="crudStudent.html">Main Menu</a></div>
</body>
</html>