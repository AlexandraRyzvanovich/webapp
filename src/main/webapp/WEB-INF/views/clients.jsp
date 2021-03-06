<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mtt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="locale"/>
<title><fmt:message key="title.clients"/></title>
<mtt:mainlayout>
    <section>
        <h1><fmt:message key="clients.header"/> </h1>
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
                    <th><fmt:message key="table.trainerName"/></th>
                    <th><fmt:message key="table.chooseNewTrainer"/></th>
                    <th></th>
                </tr>
                <c:forEach var="client" items="${requestScope.clients}">
                    <tr>
                        <td>${client.firstName} ${client.lastName} </td>
                        <td>${client.email}</td>
                        <td>${client.trainerName}</td>
                        <td>
                            <select id="${client.id}" onchange="change(this)">
                                <c:forEach var="trainer" items="${requestScope.trainers}">
                                    <option value="${trainer.userId}">${trainer.firstName} ${trainer.lastName}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <form method="post" action="clients">
                                <input type="hidden" name="command" value="setTrainer">
                                <input hidden name="userId" value="${client.id}"/>
                                <input hidden title="${client.id}" name="trainerId"
                                       value="${requestScope.trainers[0].userId}"/>
                                <button type="submit">
                                    <fmt:message key="button.submit"/>
                                </button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
                </c:otherwise>
            </c:choose>
        </div>
    </section>
</mtt:mainlayout>
<script>
    function change(select) {
        document.querySelector('input[title="' + select.id + '"]').value = select.value;
    }
</script>
