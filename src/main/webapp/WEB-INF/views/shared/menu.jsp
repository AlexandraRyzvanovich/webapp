<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<style>
    <%@include file="/resources/css/menu.css"%>
</style>
<aside>
    <div class="category-wrap">
        <h3>Menu</h3>
        <c:set var="role" scope="session"/>
        <c:choose>
            <c:when test="${role == 'TRAINER'}">
                <div class="sidenav">
                    <a href="/clients">Clients</a>
                    <a href="/reviews">Reviews</a>
                </div>
            </c:when>
            <c:when test="${role == 'CLIENT'}">
                <div class="sidenav">
                    <a href="/subscripion">Subscription</a>
                    <button class="dropdown-btn">Program
                        <i class="fa fa-caret-down"></i>
                    </button>
                    <div class="dropdown-container">
                        <a href="/food">Food</a>
                        <a href="/exercises">Excesses</a>
                    </div>
                    <a href="/reviews">Reviews</a>
                </div>
            </c:when>
            <c:when test="${role == 'ADMIN'}">
                <div class="sidenav">
                    <a href="/clients">Clients</a>
                </div>
            </c:when>
        <c:otherwise>
            <div class="sidenav">
                <a href="/clients">Clients</a>
            </div>
            <div class="sidenav">
                <a href="/clients">Excesses</a>
            </div>
            <div class="sidenav">
                <a href="/clients">Reviews</a>
            </div>
            <div class="sidenav">
                <a href="/clients">Food</a>
            </div>


        </c:otherwise>
        </c:choose>
    </div>
</div>
</aside>
<script>
    var dropdown = document.getElementsByClassName("dropdown-btn");
    var i;

    for (i = 0; i < dropdown.length; i++) {
        dropdown[i].addEventListener("click", function() {
            this.classList.toggle("active");
            var dropdownContent = this.nextElementSibling;
            if (dropdownContent.style.display === "block") {
                dropdownContent.style.display = "none";
            } else {
                dropdownContent.style.display = "block";
            }
        });
    }
</script>
