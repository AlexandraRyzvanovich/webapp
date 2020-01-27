<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<style>
    <%@include file="/resources/css/menu.css"%>
</style>
<aside>
<div class="category-wrap">
    <h3>Menu</h3>
    <nav>
        <ul class="aside-menu">
            <c:choose>
                <c:when test="${requestScope.role == TRAINER}">
                    <li class="active"><a href="">Work</a></li>
                    <li><a href="">Clients</a></li>
                    <li><a href="">Diet</a></li>
                    <li><a href="">Exercises</a></li>
                    <li><a href="">Reviews</a></li>
                </c:when>
                <c:when test="${requestScope.role == CLIENT}">
                    <li class="active"><a href="">Training </a></li>
                    <li><a href="">Diets</a></li>
                    <li><a href="">Foto</a></li>
                    <li><a href="">Our Team</a></li>
                    <li><a href="">Our Partners</a></li>
                </c:when>
            </c:choose>
        </ul>
    </nav>
</div>
</aside>
