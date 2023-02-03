<%@page import="School.Student"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <% Student s=(Student) session.getAttribute("updatedata"); %>
 <form action="sagarss" method="get">
 id: <input type="text" value=<%=s.getId() %> name="id"><br><br>
 name: <input type="text" value=<%=s.getName() %> name="name"><br><br>
 stream: <input type="text" value=<%=s.getStream() %> name="stream"><br><br>
 fees:  <input type="text" value=<%=s.getFees() %> name="fees"><br><br>
 <input type="submit">

 </form>
</body>
</html>