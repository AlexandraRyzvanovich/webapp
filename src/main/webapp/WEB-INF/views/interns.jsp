<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mtt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="locale"/>
<title><fmt:message key="title.interns"/></title>
<mtt:mainlayout>
    <section>
        <h1 class="h1"><fmt:message key="interns.header"/></h1>
        <div class="team-row">
            <c:set var="s" value="${requestScope.interns}" scope="request"></c:set>
            <c:forEach var="intern" items="${s}">
                <form method="GET" name="internCard">
                    <figure style="background: transparent;">
                        <img src="<c:url value="/resources/images/avatar.jpg"/>" style="width: 40%; height: 10%;">
                    </figure>
                    <span style="position: fixed; margin: 1% -5%; font-family: cursive; font-size: larger;">${intern.firstName} ${intern.lastName} </span>
                    <input type="hidden" name="command" value="getInternTrainerProgram">
                    <input hidden name="id" value="${intern.userId}"/>
                    <button type="submit" style="position: fixed; margin: 5% -3%; width: 7%; background: #E1D070" >
                        <fmt:message key="button.viewClient"/>
                    </button>
                </form>
            </c:forEach>
        </div>
    </section>
</mtt:mainlayout>
