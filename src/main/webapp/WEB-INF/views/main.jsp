<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mtt" tagdir="/WEB-INF/tags" %>

<mtt:mainlayout>
    <jsp:attribute name="main"></jsp:attribute>
    <jsp:body>
        <section>
            MAIN
            <p>
                Наша цель — открыть вам прекрасный мир фитнеса, сделать его доступным и любимым. Мы любим свое дело и хотим, чтобы вы получали такое же удовольствие от занятий, как мы!

                Мы хотим делать ваши мечты реальностью: быть здоровой, надеть платье размера S, сесть на шпагат, иметь ровную осанку, видеть кубики на животе, и, конечно, всегда улыбаться отражению в зеркале. Мы развиваемся вместе с вами: появляются новые направления клубной жизни, постоянное улучшение условий в зале для вашего комфорта:

                бесплатный wi-fi,
                оплата наличными и по карте,
                регулярное обновление инвентаря,
                интерактивное расписание — запись в 2 клика,
                питьевая вода в зале и раздевалке,
                приточно-вытяжная система вентиляции — чистый и свежий воздух залог вашего здоровья и прекрасного самочувствия,
                душевые кабины + гель для душа + фен + крем для рук,
                просторная раздевалка с удобным диванчиком,
                вкусный зеленый чай.
            </p>

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

