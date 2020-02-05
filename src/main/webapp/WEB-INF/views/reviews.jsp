<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mtt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<mtt:mainlayout>
    <section style="padding-top: 1px;">
        <h1 style="color: #E1D070;text-align: center;margin-top: 3%;">Reviews</h1>
        <c:forEach var="review" items="${requestScope.reviews}">
        <div class="container1">
            <img src="/w3images/bandmember.jpg" alt="Avatar">
            <p>${review.reviewMessage}</p>
            <span class="time-left">${review.date}</span>
            <div style="position:absolute;bottom:0;right: 10px;">
            <span class="fa fa-star checked"></span>
            <span class="fa fa-star checked"></span>
            <span class="fa fa-star checked"></span>
            <span class="fa fa-star"></span>
            <span class="fa fa-star"></span>
            </div>
        </div>
        </c:forEach>
        <form method="POST" action="reviews" >
        <input type="hidden" name="command" value="addNewReview" />
            <h2 style="color: #E1D070;text-align: center;margin-top: 3%;margin-bottom: 2%;">Add Your comment</h2>
            <label>
                <input type="text" name="review">
                <textarea type="text"  style="width: 400px;height: 200px;margin-left: 22%;border-radius: 6px; background: #383D50; color: #E1D070; opacity: 70%;"></textarea>
            </label>
            <input type="hidden" name="star" value="1" />
            <button type="submit">add</button>
          <a class="bot1" onclick="addReview()">Add review</a>
        </form>
    </section>
</mtt:mainlayout>
<script>
    function addReview() {
        var xhttp = new XMLHttpRequest();
       /* xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                window.location.replace("http://localhost:8181/");
            }
        };*/
        xhttp.open("post", "/reviews?command=addNewReview", true);
        xhttp.send();
    }
</script>
