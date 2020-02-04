<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mtt" tagdir="/WEB-INF/tags" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<mtt:mainlayout>
    <section style="padding-top: 1px;">
        <h1 style="color: #E1D070;text-align: center;margin-top: 3%;">Reviews</h1>
        <div class="container1">
            <img src="/w3images/bandmember.jpg" alt="Avatar">
            <p>Hello. How are you today?</p>
            <span class="time-left">11:00</span>
            <div style="position:absolute;bottom:0;right: 10px;">
            <span class="fa fa-star checked"></span>
            <span class="fa fa-star checked"></span>
            <span class="fa fa-star checked"></span>
            <span class="fa fa-star"></span>
            <span class="fa fa-star"></span>
            </div>
        </div>

        <div class="container1 darker">
            <img src="/w3images/avatar_g2.jpg" alt="Avatar" class="right">
            <p>Hey! I'm fine. Thanks for asking!</p>
            <span class="time-left">11:01</span>
            <div style="position:absolute;bottom:0;">
                <span class="fa fa-star checked"></span>
                <span class="fa fa-star checked"></span>
                <span class="fa fa-star checked"></span>
                <span class="fa fa-star checked"></span>
                <span class="fa fa-star"></span>
            </div>
        </div>

        <div class="container1">
            <img src="/w3images/bandmember.jpg" alt="Avatar">
            <p>Sweet! So, what do you wanna do today?</p>
            <span class="time-left">11:02</span>
            <div style="position:absolute;bottom:0;right: 10px;">
                <span class="fa fa-star checked"></span>
                <span class="fa fa-star checked"></span>
                <span class="fa fa-star checked"></span>
                <span class="fa fa-star checked"></span>
                <span class="fa fa-star checked"></span>
            </div>
        </div>

        <div class="container1 darker">
            <img src="/w3images/avatar_g2.jpg" alt="Avatar" class="right">
            <p>Nah, I dunno. Play soccer.. or learn more coding perhaps?</p>
            <span class="time-left">11:05</span>
            <div style="position:absolute;bottom:0;">
                <span class="fa fa-star checked"></span>
                <span class="fa fa-star checked"></span>
                <span class="fa fa-star checked"></span>
                <span class="fa fa-star checked"></span>
                <span class="fa fa-star"></span>
            </div>
        </div>
        <form method="POST" action="reviews" >
        <input type="hidden" name="command" value="addNewReview" />
            <h2 style="color: #E1D070;text-align: center;margin-top: 3%;margin-bottom: 2%;">Add Your comment</h2>
            <label>
                <textarea type="text" name="review" style="width: 400px;height: 200px;margin-left: 22%;border-radius: 6px; background: #383D50; color: #E1D070; opacity: 70%;"></textarea>
            </label>
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
