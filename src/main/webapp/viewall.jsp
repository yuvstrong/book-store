<%@page import="com.js.dto.Book"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>list off all books</h1>
<table border="2px solid blue">
	<tr>
	<th>Bid</th>
	<th>Bname</th>
	<th>Bauthor</th>
	<th>Bpage</th>
	<th>Bprice</th>
	<th>DELETE</th>
	<th>UPDATE</th>
	</tr>
	
	<% ArrayList<Book> books=(ArrayList)request.getAttribute("data");
	for(Book b:books){
	%>
	<tr>
	<td><%= b.getBid() %></td>
	<td><%= b.getBname() %></td>
	<td><%= b.getBauthor() %></td>	
	<td><%= b.getBpage() %></td>
	<td><%= b.getBprice() %></td>	
	<td><a href="delete?Bid=<%= b.getBid()%>">delete</a></td>
	<td><a  href="update1?Bid=<%= b.getBid() %>">edit</a></td>
	
	</tr>
	<%} %>

</table>

<a href="welcom.html">HOME</a>


</body>
</html>