<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<mt:loginlayout>
    <jsp:attribute name="login">login</jsp:attribute>
</mt:loginlayout>
<%--<%@ include file="shared/header.jsp" %>--%>
<form method="POST" action="login"/>
<input type="hidden" name="command" value="login" />
<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login">

            <span class="login100-form-title">
                    Welcome Fatass
                </span>
            <span class="login100-form-avatar">
               <img src="/resources/images/fitness_logo.png"/>
                </span>
            <div class="wrap-input100" data-validate="Enter username">
                <input class="input100" type="text" name="login" placeholder="login">
                <span class="focus-input100"></span>
            </div>

            <div class="wrap-input100" data-validate="Enter password">
                <input class="input100" type="password" name="password" placeholder="password">
                <span class="focus-input100"></span>
            </div>
            <div class="container-login100-form-btn">
                <button type="submit" class="login100-form-btn">
                    Login
                </button>
            </div>
        </div>
    </div>
</div>
<%--<%@ include file="shared/footer.jsp" %>--%>
