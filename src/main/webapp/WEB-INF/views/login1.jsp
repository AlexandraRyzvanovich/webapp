<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="mt" tagdir="/WEB-INF/tags" %>
<mt:loginlayout>
    <jsp:attribute name="login">login</jsp:attribute>
</mt:loginlayout>
<form method="POST" action="login"/>
<input type="hidden" name="command" value="login" />
<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100 p-t-85 p-b-20">

            <span class="login100-form-title p-b-70">
                    Welcome Fatass Login1
                </span>
            <span class="login100-form-avatar">
               <img src="/resources/images/fitness_logo.png"/>
                </span>
            <div class="wrap-input100 validate-input m-t-85 m-b-35" data-validate="Enter username">
                <input class="input100" type="text" name="login">
                <span class="focus-input100"></span>
            </div>

            <div class="wrap-input100 validate-input m-b-50" data-validate="Enter password">
                <input class="input100" type="password" name="password">
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
