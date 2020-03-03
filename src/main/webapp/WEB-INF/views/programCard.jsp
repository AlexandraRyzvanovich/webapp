<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mtt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="locale"/>
<mtt:mainlayout>
    <section>
        <h1><fmt:message key="internCard.header"/></h1>
        <c:if test="${requestScope.currentProgram .size() < 1}">
            <fmt:message key="message.trainingProgramNotFound"/>
        </c:if>
        <div>
            <c:forEach var="program" items="${requestScope.currentProgram}">
            <table cellspacing="0">
                <tr>
                    <th><fmt:message key="table.currentDiet"/></th>
                    <th><fmt:message key="table.startDate"/></th>
                    <th><fmt:message key="table.endDate"/></th>
                    <th><fmt:message key="table.currentStatus"/></th>
                </tr>
                <tr>
                    <td>${program.key.diet}</td>
                    <td>${program.key.startDate}</td>
                    <td>${program.key.endDate}</td>
                    <td>${program.key.status}</td>
                </tr>
                <tr>
                    <th></th>
                    <th></th>
                    <th><fmt:message key="table.chooseNewStatus"/></th>
                    <th></th>
                </tr>
                <tr>
                <td></td>
                <td></td>
                <td>
                    <select id="${requestScope.programStatusList}" onchange="change(this)">
                        <c:forEach var="status" items="${requestScope.programStatusList}">
                            <option value="${status}">${status}</option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <form method="POST" action="program">
                        <input type="hidden" name="command" value="updateProgramStatus">
                        <input hidden name="programId" value="${program.key.id}"/>
                        <input hidden title="${requestScope.programStatusList}" name="status"
                               value="${requestScope.programStatusList.get(0)}"/>
                        <input type="submit"/>
                    </form>
                </td>
                </tr>
            </table>
            <div style="margin-top: 50px">
                <h2><fmt:message key="header.trainingProgram"/></h2>
                <table cellspacing="0" style="  margin-bottom: 5%;">
                    <c:choose>
                        <c:when test="${program.value.size() > 0}">
                            <tr>
                                <th><fmt:message key="table.exerciseName"/></th>
                                <th><fmt:message key="table.exerciseFrequency"/></th>
                            </tr>
                            <c:forEach var="training" items="${program.value}">
                                <tr>
                                    <td>${training.exercise}</td>
                                    <td>${training.frequency} in a week</td>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <p>
                                No exercises
                            </p>
                        </c:otherwise>
                    </c:choose>
                </table>
                </c:forEach>
            </div>
    </section>
</mtt:mainlayout>
<script>
    function change(data) {
        document.querySelector('input[title="' + data.id + '"]').value = data.value;
    }
</script>