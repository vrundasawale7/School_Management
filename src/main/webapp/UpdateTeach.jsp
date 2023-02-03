<%@page import="School.Teacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%Teacher t=(Teacher) session.getAttribute("updateteacherdata"); %>
<form action="updatedatateacher" method="get">
id: <input type="text" value=<%= t.getId() %> name="id"><br><br>
name:<input type="text" value=<%= t.getName() %> name="name"><br><br>
sal:<input type="text" value=<%= t.getSal() %> name="sal"><br><br>
sub:<input type="text" value=<%= t.getSub() %> name="sub"><br><br>
<input type="submit">
</form>
</body>
</html>