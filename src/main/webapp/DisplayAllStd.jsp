<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="School.Student"%>
<%@page import="javax.persistence.Query"%>
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
Query q= em.createQuery("select s from Student s");
List<Student> s=q.getResultList(); %>


<table border="2" cellspacint="5px" align="center" cellpadding="10px">
<th>Id</th>
<th>Name</th>
<th>Stream</th>
<th>Fees</th>
<% for(Student a:s ){ %>
<tr>
<td><%= a.getId() %></td>
<td><%= a.getName() %></td>
<td><%= a.getStream() %></td>
<td><%= a.getFees() %></td>
</tr>
<%} %>
</table>
<br><br><br>
<div> <a href="crudStudent.html">Main Menu</a></div>
</body>
</html>