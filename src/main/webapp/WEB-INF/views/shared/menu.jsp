<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>

<style>
    <%@include file="/resources/css/menu.css"%>
</style>
<aside style="margin-top: 2%;">
    <div class="category-wrap">
        <h2>Menu</h2>
        <c:set var="s" value="${sessionScope.role}" scope="session"></c:set>
            <c:if test="${'TRAINER'}">
                <div class="sidenav">
                    <a href="/clients">Clients</a>
                    <a href="/reviews?command=getReviews">Reviews</a>
                </div>
            </c:if>
            <c:if test="${s == 'CLIENT'}">
                <div class="sidenav">
                    <a href="/training-program?command=getTrainingProgram">Training program</a>
                    <a href="/subscriptions?command=getAvailableSubscriptions">Subscription</a>
<%--
                    <button class="dropdown-btn">Your program
                        <i class="fa fa-caret-down"></i>
                    </button>
                    <div class="dropdown-container">
                        <a href="/diet?command=getFoodList">Food</a>
                        <a href="/exercises?command=getExerciseList">Excesses</a>
                    </div>--%>
                    <a href="/reviews?command=getReviews">Reviews</a>
                </div>
            </c:if>
            <c:if test="${s == 'ADMIN'}">
                <div class="sidenav">
                    <a href="/clients?command=getClients">Clients</a>
                </div>
                <div class="sidenav">
                    <a href="/clients">Clients2</a>
                </div>
                <div class="sidenav">
                    <a href="/client-card">Food</a>
                </div>
            </c:if>
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
