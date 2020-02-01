<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mtt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8"/>
<mtt:mainlayout>
    <jsp:attribute name="main"></jsp:attribute>
    <jsp:body >
        <form method="GET" action="training-program" />
        <input type="hidden" name="command" value="getTrainingProgram">

        <section style="padding: 18px 18px;">
            <h1 style="color: #E1D070;text-align: center;margin-bottom: 3%;">Training Program</h1>
            <table cellspacing="0">
                <c:forEach var="program" items ="${program}"/>
                <tr>
                    <th>Exercise description</th>
                    <th>${program.exersiseDescription}</th>
                    <th></th>
                </tr>
                <tr>
                    <td>Diet</td>
                    <td>${program.dietDescription}</td>
                    <td><a href="/diet">Edit</a></td>
                </tr>
                <tr>
                    <td>Exercises</td>
                    <td>100%</td>
                    <td>Да</td>
                </tr>
                <tr>
                    <td>Etiam dolor</td>
                    <td>50%</td>
                    <td>Да</td>
                </tr>
                <tr>
                    <td>Etiam dolor</td>
                    <td>0%</td>
                    <td>Да</td>
                </tr>
                <tr>
                    <td>Etiam dolor</td>
                    <td>100%</td>
                    <td>Да</td>
                </tr>
            </table>
        </section>
        </form>

        <jsp:include page="/WEB-INF/views/shared/footer.jsp"></jsp:include>
    </jsp:body>
</mtt:mainlayout>

