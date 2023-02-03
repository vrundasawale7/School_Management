<%@page import="School.Teacher"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
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
<% EntityManagerFactory emf=Persistence.createEntityManagerFactory("vrunda");
EntityManager em=emf.createEntityManager();
EntityTransaction et=em.getTransaction();
Query q= em.createQuery("select t from Teacher t");
List<Teacher> t=q.getResultList(); %>


<table border="2" cellspacint="5px" align="center" cellpadding="10px">
<th>Id</th>
<th>Name</th>
<th>Subject</th>
<th>Salary</th>
<% for(Teacher a:t ){ %>
<tr>
<td><%= a.getId() %></td>
<td><%= a.getName() %></td>
<td><%= a.getSub() %></td>
<td><%= a.getSal() %></td>
</tr>
<%} %>
</table>
<br><br><br>
<div> <a href="crudTeacher.html">Main Menu</a></div>
</body>
</html>