<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Fitness</title>
</head>

<body>

<jsp:forward page="/WEB-INF/views/login.jsp"/>


<ul>
    <li><a href="main">Home</a></li>
    <li><a href="login">Login</a></li>
    <li><a href="productList">Product  List</a>
</ul>

<jsp:forward page="/WEB-INF/views/main.jsp"/>

</body>
</html>
