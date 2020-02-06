<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mtt" tagdir="/WEB-INF/tags" %>
<style>
    @import url(https://fonts.googleapis.com/css?family=Istok+Web);
    @keyframes slidy {
        0% { left: 0%; }
        20% { left: 0%; }
        25% { left: -100%; }
        45% { left: -100%; }
        50% { left: -200%; }
        70% { left: -200%; }
        75% { left: -300%; }
        95% { left: -300%; }
        100% { left: -400%; }
    }
    * {
        box-sizing: border-box;
    }
    body, figure {
        margin: 0; background: #101010;
        font-family: Istok Web, sans-serif;
        font-weight: 100;
    }
    div#captioned-gallery {
        width: 100%; overflow: hidden;
    }
    figure.slider {
        position: relative; width: 500%;
        font-size: 0; animation: 30s slidy infinite;
    }
    figure.slider figure {
        width: 20%; height: auto;
        display: inline-block;  position: inherit;
    }
    figure.slider img { width: 100%; height: auto; }
    figure.slider figure figcaption {
        position: absolute; bottom: 0;
        background: rgba(0,0,0,0.4);
        color: #fff; width: 100%;
        font-size: 2rem; padding: .6rem;
    }


</style>
<mtt:mainlayout>
    <jsp:attribute name="main"></jsp:attribute>
    <jsp:body>
        <section>
            <%--<base href="https://s3-us-west-2.amazonaws.com/s.cdpn.io/4273/">
            <div id="captioned-gallery">
                <figure class="slider">
                    <figure>
                        <img src="hobbiton-lake.jpg" alt>
                        <figcaption>Hobbiton, New Zealand</figcaption>
                    </figure>
                    <figure>
                        <img src="wanaka-drowned-tree.jpg" alt>
                        <figcaption>Wanaka, New Zealand</figcaption>
                    </figure>
                    <figure>
                        <img src="utah-peak.jpg" alt>
                        <figcaption>Utah, United States</figcaption>
                    </figure>
                    <figure>
                        <img src="bryce-canyon-utah.jpg" alt>
                        <figcaption>Bryce Canyon, Utah, United States</figcaption>
                    </figure>
                    <figure>
                        <img src="hobbiton-lake.jpg" alt>
                        <figcaption>Hobbiton, New Zealand</figcaption>
                    </figure>
                </figure>
            </div>--%>
            <p>
                Наша цель — открыть вам прекрасный мир фитнеса, сделать его доступным и любимым. Мы любим свое дело и хотим, чтобы вы получали такое же удовольствие от занятий, как мы!
            </p>
            <p>   Мы хотим делать ваши мечты реальностью: быть здоровой, надеть платье размера S, сесть на шпагат, иметь ровную осанку, видеть кубики на животе, и, конечно, всегда улыбаться отражению в зеркале. Мы развиваемся вместе с вами: появляются новые направления клубной жизни, постоянное улучшение условий в зале для вашего комфорта:
            </p>
            <ul>
                <li> бесплатный wi-fi,</li>
                <li>оплата наличными и по карте,</li>
                <li>регулярное обновление инвентаря,</li>
                <li>интерактивное расписание — запись в 2 клика,</li>
                <li> питьевая вода в зале и раздевалке,</li>
                <li> приточно-вытяжная система вентиляции — чистый и свежий воздух залог вашего здоровья и прекрасного самочувствия,</li>
                <li>душевые кабины + гель для душа + фен + крем для рук,</li>
                <li>просторная раздевалка с удобным диванчиком,</li>
                <li> вкусный зеленый чай.</li>
            </ul>

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

