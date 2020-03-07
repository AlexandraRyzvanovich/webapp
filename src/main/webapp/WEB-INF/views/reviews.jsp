<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@taglib prefix="mtt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<mtt:mainlayout>
    <section style="padding-top: 1px;">
        <h1 style="color: #E1D070;text-align: center;margin-top: 3%;">Reviews</h1>
        <c:forEach var="review" items="${requestScope.reviews}">
        <div class="container1">
            <img src="/w3images/bandmember.jpg" alt="Avatar">
            <p style="font-family: fantasy; font-size: larger;">${review.reviewMessage}</p>
            <span class="time-left" style="margin: 6% -1%;">${review.date}</span>
        </div>
        </c:forEach>
        <c:if test="${sessionScope.role eq 'CLIENT'}">
        <form method="POST" action="reviews" >
        <input type="hidden" name="command" value="addNewReview" />
            <h2 style="color: #E1D070;text-align: center;margin-top: 3%;margin-bottom: 2%;">Add Your comment</h2>
            <label>
                <input id="reviewData" type="text" name="review" style="width: 400px;height: 200px;margin-left: 22%;border-radius: 6px; background: #383D50; color: #E1D070; opacity: 70%;" accept = "UTF-8">
            </label>
          <input type="submit" class="bot1" value="Add review"/>
        </form>
        </c:if>
    </section>
</mtt:mainlayout>
