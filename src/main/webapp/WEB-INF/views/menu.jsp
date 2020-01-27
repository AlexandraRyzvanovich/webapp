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

    /* Style the sidenav links and the dropdown button */
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

    /* On mouse-over */
    .sidenav a:hover, .dropdown-btn:hover {
        color: #f1f1f1;
    }

    /* Main content */
    .main {
        margin-left: 200px; /* Same as the width of the sidenav */
        font-size: 20px; /* Increased text to enable scrolling */
        padding: 0px 10px;
    }

    /* Add an active class to the active dropdown button */
    .active {
        background-color: green;
        color: white;
    }

    /* Dropdown container (hidden by default). Optional: add a lighter background color and some left padding to change the design of the dropdown content */
    .dropdown-container {
        display: none;
        background-color: #ADC5FF;
        padding-left: 8px;
    }

    /* Optional: Style the caret down icon */
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
                    <a href="/subscripion">Subscription</a>
                    <a href="#services">Clients</a>
                    <a href="#contact">Contact</a>
                    <button class="dropdown-btn">Program
                        <i class="fa fa-caret-down"></i>
                    </button>
                    <div class="dropdown-container">
                        <a href="/diet">Food</a>
                        <a href="#">Excesses</a>
                    </div>
                    <a href="#contact">Search</a>
                </div>
            </c:when>
            <c:when test="${requestScope.role == CLIENT}">
                <div class="sidenav">
                    <a href="/subscripion">CLIENT</a>
                    <a href="#services">CLIENT</a>
                    <a href="#contact">CLIENT</a>
                    <button class="dropdown-btn">Program
                        <i class="fa fa-caret-down"></i>
                    </button>
                    <div class="dropdown-container">
                        <a href="/diet">Food</a>
                        <a href="#">Excesses</a>
                    </div>
                    <a href="#contact">Search</a>
                </div>
            </c:when>
        </c:choose>
    </div>
</div>
</aside>
<script>
    /* Loop through all dropdown buttons to toggle between hiding and showing its dropdown content - This allows the user to have multiple dropdowns without any conflict */
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
