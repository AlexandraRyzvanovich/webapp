<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mtt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="locale"/>
<mtt:mainlayout>
    <section>
        <h1>Your program</h1>
        <div>
            <table cellspacing="0">
                <tr>
                    <th>Diet</th>
                    <th>Start date</th>
                    <th>End date</th>
                    <th>Actual Status</th>
                    <th>Choose new status</th>
                    <th></th>
                </tr>
                <c:forEach var="program" items="${requestScope. currentProgram}">
                    <tr>
                        <td>${program.diet}</td>
                        <td>${program.startDate}</td>
                        <td>${program.endDate}</td>
                        <td>${program.status}</td>
                        <td>
                            <select onchange="changeStatus(this)">
                                <c:forEach var="status" items="${requestScope.programStatusList}">
                                    <option value="${status}">${status}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <form method="POST" action="internCard">
                                <input type="hidden" name="command" value="updateProgramStatus">
                                <input hidden name="programId" value="${program.id}"/>
                                <input hidden name="status" value="${requestScope.programStatusList.get(1)}"/>
                                <input type="submit"/>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div style="margin-top: 50px">
            <h3>Training program</h3>
            <table cellspacing="0">
                <tr>
                    <th>Exercise name</th>
                    <th>Frequency</th>
                </tr>
                <c:forEach var="program" items="${requestScope.currentTrainingProgram}">
                    <tr>
                        <td>${program.exercise}</td>
                        <td>${program.frequency} in a week</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </section>
</mtt:mainlayout>
<script>
    function changeStatus(data) {
        document.querySelector('input[title="'+ data.id +'"]').value = data.value;
    }
</script>