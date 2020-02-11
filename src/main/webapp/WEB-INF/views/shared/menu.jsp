<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>

<style>
    <%@include file="/resources/css/menu.css"%>
</style>
<aside style="margin-top: 2%;">
    <div class="category-wrap">
        <h2>Menu</h2>
        <c:set var="s" value="${sessionScope.role}" scope="session"></c:set>
            <c:if test="${s =='TRAINER'}">
                <div class="sidenav">
                    <a href="/interns?command=getInterns">Interns</a>
                    <a href="/reviews?command=getReviews">Reviews</a>
                </div>
            </c:if>
            <c:if test="${s == 'CLIENT'}">
                <div class="sidenav">
                    <a href="/training-program?command=getProgram">Your training program</a>
                    <a href="/subscriptions?command=getAvailableSubscriptions">Subscription</a>
                    <a href="/reviews?command=getReviews">Reviews</a>
                </div>
            </c:if>
            <c:if test="${s == 'ADMIN'}">
                <div class="sidenav">
                    <a href="/clients?command=getClients">Clients</a>
                    <a href="/bonus?command=getClients">Bonus</a>
                </div>
            </c:if>
    </div>
</div>
</aside>
