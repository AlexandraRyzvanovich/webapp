<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="mtt" tagdir="/WEB-INF/tags" %>
<mtt:mainlayout>
    <jsp:attribute name="main"></jsp:attribute>
</mtt:mainlayout>

<style>
    table {
        overflow:hidden;
        border:1px solid #d3d3d3;
        background:#fefefe;
        width:70%;
        margin:5% auto ;
        -moz-border-radius:5px; /* FF1+ */
        -webkit-border-radius:5px; /* Saf3-4 */
        border-radius:5px;
        -moz-box-shadow:   4px rgba(0, 0, 0, 0.2);
        -webkit-box-shadow:   4px rgba(0, 0, 0, 0.2);
    }

    th, td {
        padding:18px 28px 18px;
        text-align:center;
    }

    th {
        padding-top:22px;
        text-shadow: 1px 1px 1px #fff;
        background:#e8eaeb;
    }

    td {
        border-top:1px solid #e0e0e0;
        border-right:1px solid #e0e0e0;
    }

    tr.odd-row td {
        background:#f6f6f6;
    }

    td.first, th.first {
        text-align:left
    }

    td.last {
        border-right:none;
    }

    td {
        background: -moz-linear-gradient(100% 25% 90deg, #fefefe, #f9f9f9);
        background: -webkit-gradient(linear, 0% 0%, 0% 25%, from(#f9f9f9), to(#fefefe));
    }

    tr.odd-row td {
        background: -moz-linear-gradient(100% 25% 90deg, #f6f6f6, #f1f1f1);
        background: -webkit-gradient(linear, 0% 0%, 0% 25%, from(#f1f1f1), to(#f6f6f6));
    }

    th {
        background: -moz-linear-gradient(100% 20% 90deg, #e8eaeb, #ededed);
        background: -webkit-gradient(linear, 0% 0%, 0% 20%, from(#ededed), to(#e8eaeb));
    }

    tr:first-child th.first {
        -moz-border-radius-topleft:5px;
        -webkit-border-top-left-radius:5px; /* Saf3-4 */
    }

    tr:first-child th.last {
        -moz-border-radius-topright:5px;
        -webkit-border-top-right-radius:5px; /* Saf3-4 */
    }

    tr:last-child td.first {
        -moz-border-radius-bottomleft:5px;
        -webkit-border-bottom-left-radius:5px; /* Saf3-4 */
    }

    tr:last-child td.last {
        -moz-border-radius-bottomright:5px;
        -webkit-border-bottom-right-radius:5px; /* Saf3-4 */
    }
    #wrapper {
        max-width: 960px;
        margin: auto;
    }
    aside {
        float: left;
        width: 250px;
    }
    section {
        margin-left: 280px;
        padding-bottom: 50px;
    }
    figure figcaption {
        font-size: 16px;
        font-weight: 300;
        margin-top: 5px;
    }

    figure div {
        font-size: 14px;
        color: #29c5e6;
    }

    .team-row figure {
        margin-top: 20px;
    }

    .team-row figure + figure {
        margin-left: 43px;
    }
    figure {
        display: inline-block;
        margin: 0;
        font-family: 'Oswald', sans-serif;
        font-weight: 300;
    }

    figure img {
        display: block;
        border: 1px solid #fff;
        outline: 1px solid #c9c9c9;
    }

    figure figcaption {
        font-size: 16px;
        font-weight: 300;
        margin-top: 5px;
    }

    figure figcaption span {
        display: block;
        font-size: 14px;
        color: #29c5e6;
    }
    section > figure + figure {
        margin-left: 28px;
    }
</style>
<div id="wrapper">
    <jsp:include page="/WEB-INF/views/shared/header.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>
    <section>
    <table style="padding-left: 100px" cellspacing="0">
        <tr>
            <th>Lorem ipsum</th>
            <th>Lorem ipsum</th>
            <th>Lorem ipsum</th>
        </tr>
        <tr>
            <td>Etiam dolor</td>
            <td>100%</td>
            <td>Нет</td>
        </tr>
        <tr>
            <td>Etiam dolor</td>
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
</div>
