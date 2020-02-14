<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="locale"/>
<mt:loginlayout>
    <jsp:attribute name="login">login</jsp:attribute>
</mt:loginlayout>
<form method="POST" action="login"/>
<input type="hidden" name="command" value="login" />
<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login">
            <span class="login100-form-avatar">
               <img src="/resources/images/newLogo3.png"/>
                </span>
            <div class="wrap-input100" data-validate="Enter username">
                <input class="input100" type="text" name="login" placeholder="login" style="background-color: transparent !important;border-radius: 13px;">
                <span class="focus-input100"></span>
            </div>

            <div class="wrap-input100" data-validate="Enter password">
                <input class="input100" type="password" name="password" placeholder="password" style="background-color: transparent !important;border-radius: 13px;">
                <span class="focus-input100"></span>
            </div>
            <div class="container-login100-form-btn">
                <button type="submit" class="login100-form-btn">
                    <fmt:message key="button.submit"/>
                </button>
            </div>
        </div>
    </div>
</div>
