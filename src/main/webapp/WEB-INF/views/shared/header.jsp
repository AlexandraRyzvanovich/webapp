<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<style>
    <%@include file="/resources/css/header.css"%>
</style>
<header>
    <form method="POST" action="/logout"/>
    <input type="hidden" name="command" value="logout" />
    <ul id="navbar" class="navbar">
        <li class="login100-form-avatar2">
            <a href="main">
            <img src="/resources/images/fitness_logo.png"/></a>
        </li>
        <li>
            <button type="submit">
                Logout
            </button>
        </form>
             </li>
        <li id="navbar-right">
            <select id="lang" style="float: right;">
                <option style="background:url(/resources/images/flagru.png);" value="rus">Ru</option>
                <option style="background:url(/resources/images/usaflag.png);" value="eng">En</option>
            </select>
        </li>
    </ul>
</header>