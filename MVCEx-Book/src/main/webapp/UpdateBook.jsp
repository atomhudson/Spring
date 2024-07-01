<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1> ${appName} </h1>
	<hr>
	<a href="/">Home</a> 
	<a style="margin-left:20px;" href="/viewBooks">View Books</a>
	<hr>
	<h3>Update Book</h3>
	<c:if test="${r!=null}">
		<p style='background-color:yellow;padding:10px;'> ${r} </p>
	</c:if>
	<form action="doUpdateBook" method="post" enctype="multipart/form-data">
		Book Name: <input type="text" name="name" value="${book.name}" required/><br/><br/>
		Book Price: <input type="number" name="price" value="${book.price}" required/><br/><br/>
		Book Author Name: <input type="text" name="aname" value="${book.aname}" required/><br/><br/>
		Book Publisher Name: <input type="text" name="pname" value="${book.pname}" required/><br/><br/>
		Book Photo: <input type="file" accept="image/*" name="image" /><br/><br/>
		<img alt="" src="/getBookImage?name=${book.name}" height="200px">
		<input type="hidden" name="oldName" value="${book.name}" required />
		<input type="submit" value="UPDATE Book"/>
	</form>
</body>
</html>