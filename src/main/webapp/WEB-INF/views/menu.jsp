<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<style>
    <%@include file="/resources/css/menu.css"%>
    .sidenav {
        z-index: 1;
        top: 0;
        left: 0;
        background-color: #ADC5FF;
        overflow-x: hidden;
        padding-top: 20px;
    }

    .sidenav a, .dropdown-btn {
        padding: 6px 8px 6px 16px;
        text-decoration: none;
        font-size: 20px;
        color: #818181;
        display: block;
        border: none;
        background: none;
        width:100%;
        text-align: left;
        cursor: pointer;
        outline: none;
    }

    .sidenav a:hover, .dropdown-btn:hover {
        color: #f1f1f1;
    }

    .dropdown-container {
        display: none;
        background-color: #ADC5FF;
        padding-left: 8px;
    }

    .fa-caret-down {
        float: right;
        padding-right: 8px;
    }
</style>
<aside>
    <div class="category-wrap">
        <h3>Menu</h3>
        <c:choose>
            <c:when test="${requestScope.role == TRAINER}">
                <div class="sidenav">
                    <a href="/clients">Clients</a>
                    <a href="/reviews">Reviews</a>
                </div>
            </c:when>
            <c:when test="${requestScope.role == CLIENT}">
                <div class="sidenav">
                    <a href="/subscripion">Subscription</a>
                    <button class="dropdown-btn">Program
                        <i class="fa fa-caret-down"></i>
                    </button>
                    <div class="dropdown-container">
                        <a href="/diet">Food</a>
                        <a href="#">Excesses</a>
                    </div>
                    <a href="/reviews">Reviews</a>
                </div>
            </c:when>
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
