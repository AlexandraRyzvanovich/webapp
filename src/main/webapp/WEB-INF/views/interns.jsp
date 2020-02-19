<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mtt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="locale"/>
<mtt:mainlayout>
    <section>
        <h1><fmt:message key="interns.header"/></h1>
        <div class="team-row">
            <c:set var="s" value="${requestScope.interns}" scope="request"></c:set>
            <c:forEach var="intern" items="${s}">
                <form method="GET" name="internCard">
                    <figure>
                        <img src="/resources/images/avatar.jpg" width="96" height="96" alt="">
                    </figure>
                    <span>${intern.firstName} ${intern.lastName} </span>

                    <input type="hidden" name="command" value="getInternTrainerProgram">
                    <input hidden name="id" value="${intern.userId}"/>
                    <input type="submit" value="View Clients Card">
                </form>
            </c:forEach>
        </div>
    </section>
</mtt:mainlayout>
