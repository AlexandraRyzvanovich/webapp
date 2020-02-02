<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mtt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<mtt:mainlayout>
    <jsp:attribute name="main"></jsp:attribute>
    <jsp:body >
        <form method="GET" action="training-program" />
        <input type="hidden" name="command" value="getTrainingProgram">

        <section style="padding: 18px 18px;">
            <h1 style="color: #E1D070;text-align: center;margin-bottom: 3%;">Training Program</h1>
            <c:set var="s" value="${requestScope.trainingProgram}" scope="request"></c:set>
            <table cellspacing="0">
                <tr>
                    <td>Diet</td>
                    <td>${requestScope.trainingProgram.get().dietDescription}</td>
                    <td><a href="/diet">more</a></td>
                </tr>
                <tr>
                    <td>Exercises</td>
                    <td>${requestScope.trainingProgram.get().exerciseDescription}</td>
                    <td><a href="/diet">more</a></td>
                </tr>
                <tr>
                    <td>Additional information</td>
                    <td>${requestScope.trainingProgram.get().additionalInfo}</td>
                    <td></td>
                </tr>
            </table>
        </section>
        </form>
        <jsp:include page="/WEB-INF/views/shared/footer.jsp"></jsp:include>
    </jsp:body>
</mtt:mainlayout>

