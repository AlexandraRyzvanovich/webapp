<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mtt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="locale"/>
<title><fmt:message key="title.bonuses"/></title>
<mtt:mainlayout>
    <section>
        <h1><fmt:message key="bonus.header"/></h1>
        <div class="team-row">
            <c:set var="clients" value="${requestScope.clients}" scope="request"></c:set>
            <c:choose>
                <c:when test="${clients.size() == 0}">
                    <p><fmt:message key="message.clientsNotFound"/></p>
                </c:when>
                <c:otherwise>
                    <table cellspacing="0">
                        <tr>
                            <th><fmt:message key="table.name"/></th>
                            <th><fmt:message key="table.email"/></th>
                            <th><fmt:message key="table.currentBonus"/></th>
                            <th><fmt:message key="table.chooseNewBonus"/></th>
                            <th></th>
                        </tr>
                        <c:forEach var="client" items="${requestScope.clients}">
                            <form method="post" action="bonus">
                                <tr>
                                    <td>${client.firstName} ${client.lastName}</td>
                                    <td>${client.email}</td>
                                    <td>${client.bonus}</td>
                                    <td>
                                        <input type="text" name="bonus" required pattern="([1-9][0-9]?|100)"/>
                                    </td>
                                    <td>
                                        <input type="hidden" name="command" value="setBonus">
                                        <input hidden name="userId" value="${client.id}"/>
                                        <button type="submit">
                                            <fmt:message key="button.submit"/>
                                        </button>
                                    </td>
                                </tr>
                            </form>
                        </c:forEach>
                    </table>
                </c:otherwise>
            </c:choose>
        </div>
    </section>
</mtt:mainlayout>