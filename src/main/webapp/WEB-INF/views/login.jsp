<%@page contentType="text/html"%>
<%@ page import="corepatterns.util.*" %>
<html>
<head><title>JSP Front Controller</title></head>
<body>

<h3><center> Login </center> </h3>

<FORM method=POST action="login/controller?command=login" >
    <input type="text"  name="login" />
    <input type="password"  name="password" />
     <input type="submit" />
</FORM>

</body>
</html>