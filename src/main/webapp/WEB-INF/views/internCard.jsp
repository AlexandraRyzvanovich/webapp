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
        <table cellspacing="0">
            <tr>
                <th><fmt:message key="table.startDate"/></th>
                <th><fmt:message key="table.endDate"/></th>
                <th><fmt:message key="table.currentDiet"/></th>
                <th><fmt:message key="table.chooseNewDiet"/></th>
                <th><fmt:message key="table.currentStatus"/></th>
                <th><fmt:message key="table.chooseNewStatus"/></th>
            </tr>
            <c:forEach var="program" items="${requestScope.currentProgram}">
            <tr>
                <td>${program.startDate}</td>
                <td>${program.endDate}</td>
                <td>${program.diet}</td>
                <td>
                    <select id = "${program.id}" onchange="change(this)">
                        <c:forEach var="diets" items="${requestScope.dietList}">
                            <option value="${diets}">${diets}</option>
                        </c:forEach>
                    </select>
                </td>
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
                        <input hidden title="${requestScope.programStatusList}" name="status" value="${requestScope.programStatusList.get(0)}"/>
                        <input type="submit"/>
                    </form>
                </td>
            </tr>
            </c:forEach>
        </table>
        </div>
        <div style="margin-top: 50px">
            <h3><fmt:message key="header.trainingProgram"/></h3>
            <table cellspacing="0">
                <tr>
                    <th><fmt:message key="table.exerciseName"/></th>
                    <th><fmt:message key="table.exerciseFrequency"/></th>
                </tr>
                <c:forEach var="program" items="${requestScope.currentTrainingProgram}">
                <tr>
                    <td>${program.exercise}</td>
                    <td>${program.frequency} in a week</td>
                </tr>
                </c:forEach>
            </table>
            <div>
                <form method="POST" action="internCard">
                    <input type="hidden" name="command" value="setTrainingProgram">
                <select onchange ="changeStatus(this)" style="margin: 30px;">
                    <c:forEach var="exercise" items="${requestScope.exercises}">
                    <option value="${exercise.id}">${exercise.name}</option>
                    </c:forEach>
                </select>
                    <input hidden name="programId" value="${requestScope.currentProgram.get(0).id}"/>
                    <input hidden name="exerciseId" value="${requestScope.exercises.get(0).id}"/>
                    <input type="text"  name="frequency" style="width: 69px">
                    <input type="submit"/>
                </form>
            </div>
        </div>
    </section>
</mtt:mainlayout>
<script>
    function change(data) {
        document.querySelector('input[title="'+ data.id +'"]').value = data.value;
    }
</script>