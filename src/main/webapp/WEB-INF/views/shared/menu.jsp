<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="locale"/>
<style>
    <%@include file="/resources/css/menu.css"%>
</style>
<aside style="margin-top: 2%;">
    <div class="category-wrap">
        <h2><fmt:message key="menu.menu"/></h2>
        <c:set var="s" value="${sessionScope.role}" scope="session"></c:set>
            <c:if test="${s =='TRAINER'}">
                <div class="sidenav">
                    <a href="<c:url value="/interns?command=getInterns"/>"><fmt:message key="menu.interns"/></a>
                    <a href="<c:url value="/reviews?command=getReviews"/>"><fmt:message key="menu.reviews"/></a>
                </div>
            </c:if>
            <c:if test="${s == 'CLIENT'}">
                <div class="sidenav">
                    <a href="<c:url value="/program?command=getProgram"/>"><fmt:message key="menu.trainingProgram"/></a>
                    <a href="<c:url value="/subscriptions?command=getAvailableSubscriptions"/>"><fmt:message key="menu.subscription"/></a>
                    <a href="<c:url value="/reviews?command=getReviews"/>"><fmt:message key="menu.reviews"/></a>
                </div>
            </c:if>
            <c:if test="${s == 'ADMIN'}">
                <div class="sidenav">
                    <a href="<c:url value="/clients?command=getClients"/>"><fmt:message key="menu.clients"/></a>
                    <a href="<c:url value="/bonus?command=getClients"/>"><fmt:message key="menu.bonus"/></a>
                </div>
            </c:if>
    </div>
</div>
</aside>
