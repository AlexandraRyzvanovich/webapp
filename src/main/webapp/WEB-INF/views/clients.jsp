<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mtt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<mtt:mainlayout>
    <section>
    <h1></h1>
        <form method="GET" action="interns" />
        <input type="hidden" name="command" value="getInterns">
            <div class="team-row">
                <c:set var="s" value="${requestScope.interns}" scope="request"></c:set>
                <c:forEach var = "intern" items="${s}">
                <figure>
                    <a href="/clientItem/${intern.userId}">
                        <img src="images/sample.png" width="96" height="96" alt=""></a>
                    <figcaption>${intern.firstName} ${intern.lastName}
                        <span>ward</span>
                    </figcaption>
                </figure>
                </c:forEach>
            </div>
         <%--   <div class="team-row">
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
            </div>--%>
    </section>
</mtt:mainlayout>