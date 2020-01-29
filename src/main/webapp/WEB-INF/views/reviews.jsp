<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mtt" tagdir="/WEB-INF/tags" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
    /* Chat containers */
    .container1 {
        border: 2px solid #dedede;
        background-color: #f1f1f1;
        border-radius: 5px;
        padding: 10px;
        margin: 35px 0;
        height: 120px;
        position: relative;
    }

    /* Darker chat container */
    .darker {
        border-color: #ccc;
        background-color: #ddd;
        margin-left: 35px;
    }

    /* Clear floats */
    .container1::after {
        content: "";
        clear: both;
        display: table;
    }

    /* Style images */
    .container1 img {
        float: left;
        max-width: 60px;
        width: 100%;
        margin-right: 20px;
        border-radius: 50%;
    }

    /* Style the right image */
    .container1 img.right {
        float: right;
        margin-left: 20px;
        margin-right:0;
    }

    /* Style time text */
    .time-right {
        float: right;
        color: #aaa;
    }

    /* Style time text */
    .time-left {
        float: left;
        color: #999;
    }
    .checked {
        color: orange;
    }
</style>
<mtt:mainlayout>
    <section>
        <div class="container1">
            <img src="/w3images/bandmember.jpg" alt="Avatar">
            <p>Hello. How are you today?</p>
            <span class="time-right">11:00</span>
            <div style="position:absolute;bottom:0;right: 10;">
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
            <span class="time-right">11:02</span>
            <div style="position:absolute;bottom:0;right: 10;">
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
        <form action="post">
            <label>
                Add Your comment
                <textarea name="comments"></textarea>
            </label>
            <button type="submit">Add comment</button>
        </form>
    </section>
</mtt:mainlayout>
