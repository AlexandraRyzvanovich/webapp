<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<p style="color: red;">${errorString}</p>


<form method="POST" action="login">
    <input type="hidden" name="command" value="login" />
    <table border="0">
        <tr>
            <td>User Name</td>
            <td><input type="text" name="login" value= "${user.login}" /> </td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="text" name="password" value= "${user.password}" /> </td>
        </tr>
        <br/> ${errorLoginPassMessage}
        <br/> ${wrongAction}
        <br/> ${nullPage} <br/>
        <tr>
            <td>Remember me</td>
            <td><input type="checkbox" name="rememberMe" value= "Y" /> </td>
        </tr>
        <tr>
            <td colspan ="2">
                <input type="submit" value= "login" />
            </td>
        </tr>
    </table>
</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>