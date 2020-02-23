<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mtt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="locale"/>
<mtt:mainlayout>
    <section>
        <h1><fmt:message key="internCard.header"/></h1>
        <div>
            <c:if test="${requestScope.currentProgram.size() < 1}">
                <h3>
                    <fmt:message key="message.trainingProgramNotFound"/>
                </h3>
            </c:if>
            <c:otherwise>
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
                        <td>${program.startDate}</td>
                        <td>${program.endDate}</td>
                        <td>${program.status}</td>
                        <td>
                            <select id="${requestScope.programStatusList}" onchange="change(this)">
                                <c:forEach var="status" items="${requestScope.programStatusList}">
                                    <option value="${status}">${status}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <form method="POST" action="internCard">
                                <input type="hidden" name="command" value="updateProgramStatus">
                                <input hidden name="programId" value="${program.id}"/>
                                <input hidden title="${requestScope.programStatusList}" name="status"
                                       value="${requestScope.programStatusList.get(0)}"/>
                                <input type="submit"/>
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
                        <td>${program.diet}</td>
                        <td>
                            <select id="${requestScope.dietList}" onchange="change(this)">
                                <c:forEach var="diets" items="${requestScope.dietList}">
                                    <option value="${diets}">${diets}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <form method="POST" action="internCard">
                                <input type="hidden" name="command" value="setDiet">
                                <input hidden name="programId" value="${program.id}"/>
                                <input hidden title="${requestScope.dietList}" name="diet"
                                       value="${requestScope.dietList.get(0)}"/>
                                <input type="submit"/>
                            </form>
                        </td>
                    </tr>
            </table>
                <div style="margin-top: 50px">
                    <h2><fmt:message key="header.trainingProgram"/></h2>
                    <table cellspacing="0">
                        <tr>
                            <th><fmt:message key="table.exerciseName"/></th>
                            <th><fmt:message key="table.exerciseFrequency"/></th>
                        </tr>
                        <c:set var="training" scope="request" value="${requestScope.currentTrainingProgram}"/>
                        <c:if test="${training.}"
                        <c:forEach var="trainingProgram" items="${training}">
                            <tr>
                                <td>${trainingProgram.exercise}</td>
                                <td>${trainingProgram.frequency} in a week</td>
                            </tr>
                        </c:forEach>
                    </table>
                    <div>
                        <form method="POST" action="internCard">
                            <input type="hidden" name="command" value="setTrainingProgram">
                            <select onchange="changeStatus(this)" style="margin: 4% 1%; padding: 1%; width: 35%;">
                                <c:forEach var="exercise" items="${requestScope.exercises}">
                                    <option value="${exercise.id}">${exercise.name}</option>
                                </c:forEach>
                            </select>
                            <input hidden name="programId" value="${requestScope.currentProgram.get(0).id}"/>
                            <input hidden name="exerciseId" value="${requestScope.exercises.get(0).id}"/>
                            <input type="text" name="frequency" style="width: 7%; padding: 1%; margin: 2%;">
                            <input type="submit" style="    padding: 1%; margin: 2%; width: 15%;"/>
                        </form>
                    </div>
                </div>
            </c:forEach>
            </c:otherwise>
        </div>
    </section>
</mtt:mainlayout>
<script>
    function change(data) {
        document.querySelector('input[title="' + data.id + '"]').value = data.value;
    }
</script>