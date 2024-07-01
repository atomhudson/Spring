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
    form {
        text-align: center;
        margin: 20px 0;
    }
    form label {
        font-size: 1.2em;
    }
    form input[type="search"] {
        padding: 5px;
        font-size: 1em;
    }
    form button {
        padding: 5px 10px;
        font-size: 1em;
        background-color: #4CAF50;
        color: white;
        border: none;
        cursor: pointer;
    }
    form button:hover {
        background-color: #45a049;
    }
    .message {
        background-color: yellow;
        padding: 10px;
        text-align: center;
        margin: 10px 0;
    }
    .book-list {
        width: 80%;
        margin: 0 auto;
    }
    .book-item {
        border: 2px solid blue;
        padding: 10px;
        margin: 10px 0;
        background-color: white;
        display: flex;
        justify-content: space-between;
        align-items: center;
    }
    .book-item div {
        max-width: 70%;
    }
    .book-item h4 {
        margin: 5px 0;
    }
    .book-item button {
        background-color: red;
        color: white;
        border: 2px solid black;
        margin: 5px;
        padding: 5px;
        cursor: pointer;
    }
    .book-item button:hover {
        background-color: darkred;
    }
    .book-item img {
        max-height: 200px;
        margin-left: 20px;
    }
</style>
</head>
<body>
    <header>
        <h1>${appName}</h1>
    </header>
    <nav>
        <a href="/">Home</a>
        <a href="/viewBook">View Book</a>
    </nav>
    <form action="searchBook" method="get">
        <label>Search Book Here</label>
        <input type="search" name="name" required />
        <button>Search</button>
    </form>
    <c:if test="${msg != null}">
        <div class="message">${msg}</div>
    </c:if>
    <div class="book-list">
        <h2>Books</h2>
        <c:forEach items="${book}" var="books">
            <div class="book-item">
                <div>
                    <h4>Name: <b><c:out value="${books.name}" /></b></h4>
                    <h4>Price: <b><c:out value="${books.price}" /></b></h4>
                    <h4>Author Name: <b><c:out value="${books.aname}" /></b></h4>
                    <h4>Publisher Name: <b><c:out value="${books.pname}" /></b></h4>
                    <form action="deleteBook" method="post">
                        <input type="hidden" name="bookName" value="${books.name}" required />
                        <button>Delete Book</button>
                    </form>
                    <a href="/updateBook?name=${books.name}" style="display: block; text-align: center; background-color: green; color: white; border: 2px solid black; margin: 5px; padding: 5px; cursor: pointer;">Update Book</a>
                </div>
                <img alt="Book Image" src="/getBookImage?name=${books.name}" />
            </div>
        </c:forEach>
    </div>
</body>
</html>
