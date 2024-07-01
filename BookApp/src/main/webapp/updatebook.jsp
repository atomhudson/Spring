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
        text-align: center;
        padding: 1em 0;
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
    h3 {
        text-align: center;
    }
    .form-container {
        width: 50%;
        margin: auto;
        padding: 20px;
        background-color: white;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    .form-container input[type="text"],
    .form-container input[type="number"] {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    .form-container input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    .form-container input[type="submit"]:hover {
        background-color: #45a049;
    }
    .message {
        text-align: center;
        padding: 10px;
        margin: 20px;
        border: 1px solid #ccc;
        border-radius: 4px;
        background-color: yellow;
    }
    .book-item a.update-link {
    display: inline-block;
    padding: 5px 10px;
    margin-top: 10px;
    background-color: #4CAF50;
    color: white;
    text-decoration: none;
    border-radius: 4px;
}
.book-item a.update-link:hover {
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
        <a href="/viewBook">View Books</a>
    </nav>
    <h3>Update Book</h3>
    <c:if test="${r != null}">
        <div class="message">${r}</div>
    </c:if>
    <div class="form-container">
        <form action="doUpdateBook" method="post" enctype="multipart/form-data">
            <label for="name">Book Name:</label>
            <input type="text" id="name" name="name" value="${book.name}" required/><br/><br/>
            <label for="price">Book Price:</label>
            <input type="number" id="price" name="price" value="${book.price}" required/><br/><br/>
            <label for="aname">Book Author Name:</label>
            <input type="text" id="aname" name="aname" value="${book.aname}" required/><br/><br/>
            <label for="pname">Book Publisher Name:</label>
            <input type="text" id="pname" name="pname" value="${book.pname}" required/><br/><br/>
            <label for="photo">Book Photo:</label> <input type="file" accept="image/*" name="image" /> <br/><br/>
            <img alt="" src="/getBookImage?name=${book.name}" height="200px">
            <input type="hidden" name="oldName" value="${book.name}" required />
            <input type="submit" value="UPDATE Book"/>
        </form>
    </div>
</body>
</html>
