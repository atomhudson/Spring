<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Management</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
    }
    header {
        background-color: #4CAF50;
        color: white;
        padding: 10px 0;
        text-align: center;
    }
    nav {
        text-align: center;
        margin: 20px 0;
    }
    nav a {
        margin: 0 15px;
        text-decoration: none;
        color: #333;
    }
    nav a:hover {
        color: #4CAF50;
    }
    .message {
        background-color: yellow;
        padding: 10px;
        text-align: center;
        margin: 10px 0;
    }
    form {
        width: 50%;
        margin: 0 auto;
        padding: 20px;
        background-color: white;
        border: 1px solid #ccc;
        box-shadow: 2px 2px 10px rgba(0,0,0,0.1);
    }
    form input[type="text"],
    form input[type="number"],
    form input[type="submit"] {
        display: block;
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        font-size: 1em;
    }
    form input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        border: none;
        cursor: pointer;
    }
    form input[type="submit"]:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>
    <header>
        <h1>${appName}</h1>
    </header>
    <nav>
        <a href="/">Home</a>
        <a href="/viewBook" style="margin-left: 30px;">View Book</a>
    </nav>
    <c:if test="${r!=null}">
        <div class="message">${r}</div>
    </c:if>
    <h3 style="text-align: center;">Add Book</h3>
    <form action="addBook" method="post" enctype="multipart/form-data">
        Book Name: <input type="text" name="name" required/><br/><br/>
        Book Price: <input type="number" name="price" required/><br/><br/>
        Book Author Name: <input type="text" name="aname" required/><br/><br/>
        Book Publisher Name: <input type="text" name="pname" required/><br/><br/>
        Book Photo: <input type="file" accept="image/*" name="image" /><br/><br/>
        <input type="submit" value="Add Book"/>
    </form>
</body>
</html>
