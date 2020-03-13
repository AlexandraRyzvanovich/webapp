<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mtt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="enumValues" prefix="ctg" %>
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
                        <th><fmt:message key="table.startDate"/></th>
                        <th><fmt:message key="table.endDate"/></th>
                        <th><fmt:message key="table.currentStatus"/></th>
                        <th><fmt:message key="table.chooseNewStatus"/></th>
                        <th></th>
                    </tr>
                    <tr>
                        <td><fmt:parseDate value="${program.key.startDate}" pattern="y-M-dd"/></td>
                        <td><fmt:parseDate value="${program.key.endDate}" pattern="y-M-dd"/></td>
                        <td><ctg:programStatusValue status="${program.key.status}"/></td>
                        <td>
                            <select id="programStatusList" onchange="change(this)">
                                <ctg:programStatusesList/>
                                <c:forEach var="status" items="${programStatuses}">
                                    <option value="${status}">${status}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <form method="POST" action="internCard">
                                <input type="hidden" name="command" value="updateProgramStatus">
                                <input hidden name="programId" value="${program.key.id}"/>
                                <input hidden title="programStatusList" name="status"
                                       value="${programStatuses}"/>
                                <button type="submit">
                                    <fmt:message key="button.submit"/>
                                </button>
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <th></th>
                        <th></th>
                        <th><fmt:message key="table.currentDiet"/></th>
                        <th><fmt:message key="table.chooseNewDiet"/></th>
                        <th></th>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td><ctg:dietValue diet="${program.key.diet}"/></td>
                        <td>
                            <select id="dietList" onchange="change(this)">
                                <ctg:dietsList/>
                                <c:forEach var="diet" items="${diets}">
                                    <option value="${diet}">${diet}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <form method="POST" action="internCard">
                                <input type="hidden" name="command" value="setDiet">
                                <input hidden name="programId" value="${program.key.id}"/>
                                <input hidden title="dietList" name="diet"
                                       value="${diets}"/>
                                <button type="submit">
                                    <fmt:message key="button.submit"/>
                                </button>
                            </form>
                        </td>
                    </tr>
                </table>
                <div style="margin-top: 50px">
                    <h2><fmt:message key="header.trainingProgram"/></h2>
                    <table cellspacing="0">
                        <c:choose>
                            <c:when test="${program.value.size() > 0}">
                                <tr>
                                    <th><fmt:message key="table.exerciseName"/></th>
                                    <th><fmt:message key="table.exerciseFrequency"/></th>
                                </tr>
                                <c:forEach var="training" items="${program.value}">
                                    <tr>
                                        <td>${training.exercise}</td>
                                        <td>${training.frequency} <fmt:message key="adder.inAWeek"/></td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <p>
                                    No exercises. Please add training program below.
                                </p>
                            </c:otherwise>
                        </c:choose>
                    </table>
                    <div>
                        <form method="POST" action="internCard">
                            <input type="hidden" name="command" value="setTrainingProgram">
                            <select id="${requestScope.exercises}" onchange="change(this)"
                                    style="margin: 4% 1%; padding: 1%; width: 35%;">
                                <c:forEach var="exercise" items="${requestScope.exercises}">
                                    <option value="${exercise.id}">${exercise.name}</option>
                                </c:forEach>
                            </select>
                            <input hidden name="programId" value="${program.key.id}"/>
                            <input hidden title="${requestScope.exercises}" name="exerciseId"
                                   value="${requestScope.exercises.get(0).id}"/>
                            <input type="text" name="frequency" required pattern="([1-9])"
                                   style="width: 7%; padding: 1%; margin: 2%;">
                            <button type="submit" style="    padding: 1%; margin: 2%; width: 15%;">
                                <fmt:message key="button.submit"/>
                            </button>
                        </form>
                    </div>
                </div>
            </c:forEach>
        </div>
    </section>
</mtt:mainlayout>
<script>
    function change(data) {
        debugger;
        document.querySelector('input[title="' + data.id + '"]').value = data.value;
    }
</script>