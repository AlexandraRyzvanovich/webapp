<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mtt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<mtt:mainlayout>
    <section>
        <form action="/diet" method="post">
            <div id="myDIV" class="header">
                <h2 style="color: #E1D070;text-align: center;margin-bottom: 3%;">My Diet</h2>
                <input style="float: left; width: 300px; height: 36px; border-radius: 6px;" type="text" id="myInput">
                <span onclick="newElement()" class=" addBtn">Add</span>
            </div>
            <c:forEach var="food" items="${requestScope.foodList}">
            <ul id="myUL">
                <li class="liwithclose">${food}</li>
            </ul>
            </c:forEach>
            <a class="bot1" onclick="send()">Approve</a>
        </form>
    </section>
</mtt:mainlayout>