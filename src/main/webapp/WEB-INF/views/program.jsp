<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mtt" tagdir="/WEB-INF/tags" %>
<meta charset="UTF-8"/>
<mtt:mainlayout>
    <jsp:attribute name="main"></jsp:attribute>
    <jsp:body >
        <form method="GET" action="training-program" />
        <input type="hidden" name="command" value="getTrainingProgram">

        <section >
            <table cellspacing="0">
                <tr>
                    <th>Program</th>
                    <th>Description</th>
                    <th></th>
                </tr>
                <tr>
                    <td>Diet</td>
                    <td>100%</td>
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
        <form/>
        <section>
            <div class="team-row">
                <figure>
                    <img src="images/sample.png" width="96" height="96" alt="">
                    <figcaption>John Doe<span>Trainer</span></figcaption>
                </figure>
                <figure>
                    <img src="images/sample.png" width="96" height="96" alt="">
                    <figcaption>Saundra Pittsley<span>Trainer</span></figcaption>
                </figure>
                <figure>
                    <img src="images/sample.png" width="96" height="96" alt="">
                    <figcaption>Ericka Nobriga<span>Trainer</span></figcaption>
                </figure>
                <figure>
                    <img src="images/sample.png" width="96" height="96" alt="">
                    <figcaption>Cody Rousselle<span>Trainer</span></figcaption>
                </figure>
            </div>
            <div class="team-row">
                <figure>
                    <img src="images/sample.png" width="96" height="96" alt="">
                    <figcaption>Ericka Nobriga<span>ward</span></figcaption>
                </figure>
                <figure>
                    <img src="images/sample.png" width="96" height="96" alt="">
                    <figcaption>Cody Rousselle<span>ward</span></figcaption>
                </figure>
                <figure>
                    <img src="images/sample.png" width="96" height="96" alt="">
                    <figcaption>Ericka Nobriga<span>ward</span></figcaption>
                </figure>
                <figure>
                    <img src="images/sample.png" width="96" height="96" alt="">
                    <figcaption>Cody Rousselle<span>ward</span></figcaption>
                </figure>
            </div>
        </section>
        <jsp:include page="/WEB-INF/views/shared/footer.jsp"></jsp:include>
    </jsp:body>
</mtt:mainlayout>

