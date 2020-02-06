<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mtt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="http://code.jquery.com/jquery-2.0.2.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $('#call').click(function () {
            $.ajax({
                type: "get",
                url: "subscriptions", //this is my servlet
                data: "command=getAvailableSubscriptions",
                success: function (msg) {
                    $('#output').append(msg);
                }
            });
        });

    });
</script>

<style>
    a.a-btn-3 {
        color: #FFFFFF;
        text-decoration: none;
        font-family: 'Oswald', Arial, sans-serif;
    }

    a.a-btn-3 {
        background: #E1D070;
        background: -webkit-gradient(linear, left top, left bottom, color-stop(#80a9da, 0), color-stop(#6f97c5, 1));
        background: -webkit-linear-gradient(top, #80a9da 0%, #6f97c5 100%);
        background: -moz-linear-gradient(top, #80a9da 0%, #6f97c5 100%);
        background: -o-linear-gradient(top, #80a9da 0%, #6f97c5 100%);
        background: linear-gradient(top, #80a9da 0%, #6f97c5 100%);
        filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#80a9da', endColorstr='#6f97c5', GradientType=0);
        padding-left: 20px;
        padding-right: 80px;
        height: 38px;
        display: block;
        margin: 20px auto;
        text-align: center;
        width: 70px;
        position: relative;
        border: 1px solid #5d81ab;
        -webkit-box-shadow: 0px 1px 1px rgba(255, 255, 255, 0.8) inset, 1px 1px 3px rgba(0, 0, 0, 0.2), 0px 0px 0px 4px rgba(188, 188, 188, 0.5);
        -moz-box-shadow: 0px 1px 1px rgba(255, 255, 255, 0.8) inset, 1px 1px 3px rgba(0, 0, 0, 0.2), 0px 0px 0px 4px rgba(188, 188, 188, 0.5);
        box-shadow: 0px 1px 1px rgba(255, 255, 255, 0.8) inset, 1px 1px 3px rgba(0, 0, 0, 0.2), 0px 0px 0px 4px rgba(188, 188, 188, 0.5);
        -webkit-border-radius: 20px;
        -moz-border-radius: 20px;
        border-radius: 20px;
        overflow: hidden;
        -webkit-transition: all 0.3s linear;
        -moz-transition: all 0.3s linear;
        -o-transition: all 0.3s linear;
        transition: all 0.3s linear;
    }

    .a-btn-3-text {
        padding-top: 5px;
        display: block;
        width: 0px;
        font-size: 18px;
        white-space: nowrap;
        text-shadow: 0px 1px 1px rgba(255, 255, 255, 0.3);
        color: #446388;
        -webkit-transition: all 0.2s linear;
        -moz-transition: all 0.2s linear;
        -o-transition: all 0.2s linear;
        transition: all 0.2s linear;
    }

    .a-btn-3-slide-text {
        position: absolute;
        height: 100%;
        top: 0px;
        right: 52px;
        width: 0px;
        background: #E1D070;
        text-shadow: 0px -1px 1px #363f49;
        color: #fff;
        font-size: 18px;
        white-space: nowrap;
        text-transform: uppercase;
        text-align: left;
        text-indent: 10px;
        overflow: hidden;
        line-height: 38px;
        -webkit-box-shadow: -1px 0px 1px rgba(255, 255, 255, 0.4), 1px 1px 2px rgba(0, 0, 0, 0.2) inset;
        -moz-box-shadow: -1px 0px 1px rgba(255, 255, 255, 0.4), 1px 1px 2px rgba(0, 0, 0, 0.2) inset;
        box-shadow: -1px 0px 1px rgba(255, 255, 255, 0.4), 1px 1px 2px rgba(0, 0, 0, 0.2) inset;
        -webkit-transition: width 0.3s linear;
        -moz-transition: width 0.3s linear;
        -o-transition: width 0.3s linear;
        transition: width 0.3s linear;
    }

    .a-btn-3-icon-right {
        position: absolute;
        right: 0px;
        top: 0px;
        height: 100%;
        width: 52px;
        border-left: 1px solid #5d81ab;
        -webkit-box-shadow: 1px 0px 1px rgba(255, 255, 255, 0.4) inset;
        -moz-box-shadow: 1px 0px 1px rgba(255, 255, 255, 0.4) inset;
        box-shadow: 1px 0px 1px rgba(255, 255, 255, 0.4) inset;
    }

    .a-btn-3-icon-right span {
        width: 38px;
        height: 38px;
        opacity: 0.7;
        position: absolute;
        left: 50%;
        top: 50%;
        margin: -20px 0px 0px -20px;
        background: transparent url(/resources/images/arrow_right.png) no-repeat 50% 55%;
        -webkit-transition: all 0.3s linear;
        -moz-transition: all 0.3s linear;
        -o-transition: all 0.3s linear;
        transition: all 0.3s linear;
    }

    .a-btn-3:hover {
        padding-right: 140px;
        -webkit-box-shadow: 0px 1px 1px rgba(255, 255, 255, 0.8) inset, 1px 1px 3px rgba(0, 0, 0, 0.2);
        -moz-box-shadow: 0px 1px 1px rgba(255, 255, 255, 0.8) inset, 1px 1px 3px rgba(0, 0, 0, 0.2);
        box-shadow: 0px 1px 1px rgba(255, 255, 255, 0.8) inset, 1px 1px 3px rgba(0, 0, 0, 0.2);
    }

    .a-btn-3:hover .a-btn-3-text {
        text-shadow: 0px 1px 1px #5d81ab;
        color: #fff;
    }

    .a-btn-3:hover .a-btn-3-slide-text {
        width: 57px;
    }

    .a-btn-3:hover .a-btn-3-icon-right span {
        opacity: 1;
    }

    .a-btn-3:active {
        position: relative;
        top: 1px;
        background: #E1D070;
        -webkit-box-shadow: 1px 1px 2px rgba(0, 0, 0, 0.4) inset;
        -moz-box-shadow: 1px 1px 2px rgba(0, 0, 0, 0.4) inset;
        box-shadow: 1px 1px 2px rgba(0, 0, 0, 0.4) inset;
        border-color: #80a9da;
    }
    .back-dialog{
        width:100%;
        min-height:100%;
        background-color: rgba(0,0,0,0.5);
        overflow:hidden;
        position:fixed;
        top:0px;
    }
    .dialog-content{
        position: relative;
        overflow: hidden;
        overflow-y: auto;
        padding: 0 10 0 10;
        margin:300px auto 0px auto;
        min-width:150px;
        max-width:600px;
        min-height: 150px;
        max-height: 650px;
        padding-bottom: 10px;
        background-color: white;
        border-radius: 6px;
    }
    .dialog-title{
        margin: 0 -10 0 -10;
        text-align: center;
        position: relative;
        vertical-align: middle;
        height: 30px;
        background-color:#383D50;
        color: #fff;
    }

    .dialog-title span{
        font-size: 25px;
        padding-left: 10px;
    }
    .close-dialog{
        position: absolute;
        right: 0;
        top: 0;
        text-align: center;
        color: #fff;
        background-color:#383D50;
        height: 30px;
        width: 30px;
        border:0;
        text-decoration: none;
    }

    .close-dialog:before{
        font-family: Arial;
        color: rgba(255, 255, 255, 0.9);
        content: "x";
        font-size: 20px;
        text-shadow: 0 -1px rgba(0, 0, 0, 0.5);
        outline: none;
    }
    /* Кнопка открытия окна */
    .button {
        position: relative;
        vertical-align: middle;
        width: 98%;
        margin-left: 1%;
        margin-right: 1%;
        padding-left: 8%;
        padding-right: 8%;
        padding-top: 4%;
        padding-bottom: 4%;
        font-size: 22px;
        color: white;
        text-align: center;
        text-shadow: 0 1px 2px rgba(0, 0, 0, 0.25);
        background: #3498db;
        border: 0;
        border-bottom: 2px solid #2a8bcc;
        cursor: pointer;
        -webkit-box-shadow: inset 0 -3px #2a8bcc;
        box-shadow: inset 0 -3px #2a8bcc;
        outline: none;
    }
    .button:active {
        top: 1px;
        outline: none;
        -webkit-box-shadow: none;
        box-shadow: none;
    }
    .row {
        display: -ms-flexbox; /* IE10 */
        display: flex;
        -ms-flex-wrap: wrap; /* IE10 */
        flex-wrap: wrap;
        margin: 0 -16px;
    }

    .col-25 {
        -ms-flex: 25%; /* IE10 */
        flex: 25%;
    }

    .col-50 {
        -ms-flex: 50%; /* IE10 */
        flex: 50%;
    }

    .col-75 {
        -ms-flex: 75%; /* IE10 */
        flex: 75%;
    }

    .col-25,
    .col-50,
    .col-75 {
        padding: 0 16px;
    }

    .container {
        background-color: #f2f2f2;
        padding: 5px 20px 15px 20px;
        border: 1px solid lightgrey;
        border-radius: 3px;
    }

    input[type=text] {
        width: 100%;
        margin-bottom: 20px;
        padding: 12px;
        border: 1px solid #ccc;
        border-radius: 3px;
    }

    label {
        margin-bottom: 10px;
        display: block;
    }

    .icon-container {
        margin-bottom: 20px;
        padding: 7px 0;
        font-size: 24px;
    }

    .btn {
        background-color: #4CAF50;
        color: white;
        padding: 12px;
        margin: 10px 0;
        border: none;
        width: 100%;
        border-radius: 3px;
        cursor: pointer;
        font-size: 17px;
    }

    .btn:hover {
        background-color: #45a049;
    }

    a {
        color: #2196F3;
    }

    hr {
        border: 1px solid lightgrey;
    }

    span.price {
        float: right;
        color: grey;
    }

    @media (max-width: 800px) {
        .row {
            flex-direction: column-reverse;
        }
        .col-25 {
            margin-bottom: 20px;
        }
    }
</style>
<mtt:mainlayout>
    <jsp:attribute name="main"></jsp:attribute>
    <jsp:body>
        <form method="GET" action="subscriptions" >
        <input type="hidden" name="command" value="getAvailableSubscriptions">
        <h1 style="color: #E1D070;text-align: center;margin-bottom: 3%;">Your Subscription</h1>
        <div class="sub_div">
            <c:set var="s" value="${requestScope.subscriptionsList}" scope="request"></c:set>
            <c:forEach var = "subscriprion" items="${requestScope.subscriptionsList}">
            <table class="sub_table_left">
                <tr>
                    <td colspan="2">${subscriprion.name}</td>
                </tr>
                <tr>
                    <td colspan="2">${subscriprion.description}/></td>
                </tr>
                <tr>
                    <td class="sub_table_period">Period</td>
                    <td>${subscriprion.period}</td>
                </tr>
                <tr>
                    <td style="opacity: 100% !important;" colspan="2"><a href="#" onclick="opendialog()" class="a-btn-3">
                        <span class="a-btn-3-text">Buy</span>
                        <span class="a-btn-3-slide-text">${subscriprion.price}</span>
                        <span class="a-btn-3-icon-right"><span></span></span>
                    </a></td>
                </tr>
            </table>
            </c:forEach>
        </div>
            <%--<table class="sub_table_right">
                <tr>
                    <td colspan="2">Subscription Name2</td>
                </tr>
                <tr>
                    <td colspan="2">Subscription Description2</td>
                </tr>
                <tr>
                    <td>Period</td>
                    <td>1 month</td>
                </tr>
                <tr>
                    <td style="opacity: 100% !important;" colspan="2">
                        <a href="#" class="a-btn-3">
                            <span class="a-btn-3-text">Buy</span>
                            <span class="a-btn-3-slide-text">200$</span>
                            <span class="a-btn-3-icon-right"><span></span></span>
                        </a>
                    </td>
                </tr>
            </table>
            <table class="sub_table_left down">
                <tr>
                    <td colspan="2">Subscription Name</td>
                </tr>
                <tr>
                    <td colspan="2">Subscription Description</td>
                </tr>
                <tr>
                    <td>Period</td>
                    <td>1 month</td>
                </tr>
                <tr>
                    <td colspan="2"><a href="#" class="a-btn-3">
                        <span class="a-btn-3-text">Buy</span>
                        <span class="a-btn-3-slide-text">100$</span>
                        <span class="a-btn-3-icon-right"><span></span></span>
                    </a></td>
                </tr>
            </table>
            <table class="sub_table_right down">
                <tr>
                    <td colspan="2">Subscription Name2</td>
                </tr>
                <tr>
                    <td colspan="2">Subscription Description2</td>
                </tr>
                <tr>
                    <td>Period</td>
                    <td>1 month</td>
                </tr>
                <tr>
                    <td colspan="2"><a href="#" class="a-btn-3">
                        <span class="a-btn-3-text">Buy</span>
                        <span class="a-btn-3-slide-text">200$</span>
                        <span class="a-btn-3-icon-right"><span></span></span>
                    </a></td>
                </tr>
            </table>--%>
        </div>
        </form>
        <div class="back-dialog" id="dialog">
            <!-- Блок с нашим контентом -->
            <div class="dialog-content">
                <!-- Заголовок и кнопка закрытия окна -->
                <div class="dialog-title">
                    <span>Введите данные для оплаты</span>
                    <a class='close-dialog' href='javascript: closedialog()'></a>
                </div>
               <form method="post">
                   <div class="col-50">
                       <div class="icon-container">
                           <i class="fa fa-cc-visa" style="color:navy;"></i>
                           <i class="fa fa-cc-amex" style="color:blue;"></i>
                           <i class="fa fa-cc-mastercard" style="color:red;"></i>
                           <i class="fa fa-cc-discover" style="color:orange;"></i>
                       </div>
                       <label for="cname">Name on Card</label>
                       <input type="text" id="cname" name="cardname" placeholder="John More Doe">
                       <label for="ccnum">Credit card number</label>
                       <input type="text" id="ccnum" name="cardnumber" placeholder="1111-2222-3333-4444">
                       <label for="expmonth">Exp Month</label>
                       <input type="text" id="expmonth" name="expmonth" placeholder="September">
                       <div class="row">
                           <div class="col-50">
                               <label for="expyear">Exp Year</label>
                               <input type="text" id="expyear" name="expyear" placeholder="2018">
                           </div>
                           <div class="col-50">
                               <label for="cvv">CVV</label>
                               <input type="text" id="cvv" name="cvv" placeholder="352">
                           </div>
                       </div>
                   </div>
                   <a class="bot1" onclick="logout()">Logout</a>
               </form>
            </div>
        </div>
    </jsp:body>
</mtt:mainlayout>
<script>
    $(document).ready(function(){
        $("#dialog").hide(); //скрываем окно при загрузке страница
    });

    function opendialog(){
        $("#dialog").fadeIn(); //плавное появление блока
    }

    function closedialog(){
        $("#dialog").fadeOut(); //плавное исчезание блока
    }
</script>