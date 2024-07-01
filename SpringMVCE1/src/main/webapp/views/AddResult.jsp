<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
pre {
            background-color: #f5f5f5;
            padding: 10px;
            border: 1px solid #ccc;
            overflow: auto;
        }
        code {
            font-family: "Courier New", Courier, monospace;
        }
        </style>
</head>
<body>
<hr>
<pre><code>
@RequestMapping("/add")
public String result(HttpServletRequest req,HttpSession ses) {
	int n1=Integer.parseInt(req.getParameter("num1"));
	int n2=Integer.parseInt(req.getParameter("num2"));
	int n=n1+n2;
	ses.setAttribute("result", n);
	return "AddResult";
}
</code></pre>
<hr>
<h3>This is Using HttpServletRequest & HttpSession</h3>
	<h1>Addition result</h1>
	Result: <%=session.getAttribute("result") %>
	OR
	Result: ${result}
</body>
</html>