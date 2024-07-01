<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to My Spring boot Web App</h1>
	<hr>
	<h2>Addition</h2>
	<form action='add' method="post">
		1st No: <input type="number" name="num1" /><br><br>
		2nd No: <input type="number" name="num2" /><br><br>
		<input type="submit" value="ADD"/>
	</form>
	<hr>
	<h2>Sum</h2>
	<form action='sum' method="post">
		1st No: <input type="number" name="num1" /><br><br>
		2nd No: <input type="number" name="num2" /><br><br>
		<input type="submit" value="ADD"/>
	</form>
</body>
</html>