<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mtt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="locale"/>
<mtt:mainlayout>
    <jsp:attribute name="main"></jsp:attribute>
    <jsp:body>
        <section>
            <div id="captioned-gallery">
                <figure class="slider">
                    <figure>
                        <img src="<c:url value="/resources/images/slider1.jpg"/>" alt>
                    </figure>
                    <figure>
                        <img src="<c:url value="/resources/images/slider2.jpg"/>" alt>
                    </figure>
                    <figure>
                        <img src="<c:url value="/resources/images/slider3.jpg"/>" alt>
                    </figure>
                    <figure>
                        <img src="<c:url value="/resources/images/slider4.jpg"/>" alt>
                    </figure>
                    <figure>
                        <img src="<c:url value="/resources/images/slider2.jpg"/>" alt>
                    </figure>
                </figure>
            </div>
            <p style="font-size:20px;padding-top: 30px">
                <fmt:message key="main.description1"/>
            </p>
            <p style="font-size:20px;">
                <fmt:message key="main.description2"/>
            </p>
            <ul style="font-size:20px;">
                <li> <fmt:message key="main.description.pros1"/></li>
                <li><fmt:message key="main.description.pros2"/></li>
                <li><fmt:message key="main.description.pros3"/></li>
                <li><fmt:message key="main.description.pros4"/></li>
                <li> <fmt:message key="main.description.pros5"/></li>
                <li> <fmt:message key="main.description.pros6"/></li>
                <li><fmt:message key="main.description.pros7"/></li>
                <li><fmt:message key="main.description.pros8"/></li>
                <li><fmt:message key="main.description.pros9"/></li>
            </ul>
        </section>
        <jsp:include page="/WEB-INF/views/shared/footer.jsp"></jsp:include>
    </jsp:body>
</mtt:mainlayout>

