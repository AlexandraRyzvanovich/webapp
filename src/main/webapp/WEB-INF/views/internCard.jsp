<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mtt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<mtt:mainlayout>
    <section>
        <h1>Intern Card</h1>
        <div>
            <h3>Diet</h3>
        <table cellspacing="0">
            <tr>
                <th>Diet</th>
                <th>Start date</th>
                <th>End date</th>
                <th>status</th>
                <th></th>
            </tr>
            <c:forEach var="diet" items="${requestScope.currentProgram}">
                <form method="post">
            <tr>
                <td>${diet.diet}</td>
                <td>${diet.startDate}</td>
                <td>${diet.endDate}</td>
                <td>
                        <select>
                            <option></option>
                        </select>
                </td>
                <td>
                    <input name="diet" type="submit">
                    <input type="submit">
                </td>
            </tr>
                </form>
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
                    <td>${program.frequency}</td>
                </tr>
                </c:forEach>
            </table>
            <div>
            <form method="post" action="training-program">
                <select>
                    <option>Exercise name1</option>
                    <option>Exercise name2</option>
                    <option>Exercise name3</option>
                    <option>Exercise name4</option>
                </select>
                <input type="text">
                <input type="submit">
            </form>
            </div>
        </div>
    </section>
</mtt:mainlayout>