<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="locale"/>
<style>
    <%@include file="/resources/css/header.css"%>
</style>
<script>
    function logout() {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                window.location.replace("http://localhost:8181/");
            }
        };
        xhttp.open("post", "logout?command=logout", true);
        xhttp.send();
    }
</script>
<header>
    <form method="POST" action="<c:url value="/logout"/>"/>
    <input type="hidden" name="command" value="logout" />
    <ul id="navbar" class="navbar">
        <li class="login100-form-avatar2">
            <a href="<c:url value="/main"/>">
            <img src="<c:url value="/resources/images/newLogo3.png"/>"/>
            </a>
        </li>
        <li>
            <a class="bot1" onclick="logout()"><fmt:message key="button.logout"/></a>
        </li>
        </form>
             </li>
        <li id="navbar-right">
                <a href ="<c:url value="/main?sessionLocale=ru"/>"><fmt:message key="language.ru"/></a>
                <a href="<c:url value="/main?sessionLocale=en"/>"><fmt:message key="language.en"/></a>
        </li>
    </ul>
</header>