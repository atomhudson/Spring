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
<pre><code>
@RequestMapping("/sum")
public String sum(int num1,int num2,ModelMap m) {
	int n=num1+num2;
	m.addAttribute("result", n);
	return "SumResult";
}
</code></pre>
<hr>
<H3>This is using Model Map</H3>
	<h1>Sum result</h1>
	Result: ${result}
</body>
</html>