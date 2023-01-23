<%@page import="com.js.dto.Book"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>ENTER DETAILS TO UPDATE</h1>
<% Book b=(Book)request.getAttribute("book"); %>
<form action="update2">
Bid: <input type="number" name="Bid" value="<%= b.getBid() %>" readonly="readonly" ><br><br>
Bname:<input type="text" name="Bname" value="<%= b.getBname() %>"><br><br>
Bauthor: <input type="text" name="Bauthor" value="<%= b.getBauthor() %>"><br><br>
Bpage: <input type="number" name="Bpage" value="<%= b.getBpage() %>"> <br><br>
Bprice:<input type="text" name="Bprice" value="<%= b.getBprice() %>"><br><br>
<input type="submit" value="update" >
</body>
</html>