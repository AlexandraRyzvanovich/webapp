<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mtt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
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
</style>
<mtt:mainlayout>
    <jsp:attribute name="main"></jsp:attribute>
    <jsp:body>
        <form method="GET" action="subscriptions" >
        <input type="hidden" name="command" value="getAvailableSubscriptions">
        <h1 style="color: #E1D070;text-align: center;margin-bottom: 3%;">Your Subscription</h1>
        <div class="sub_div">
            <c:forEach var="s" items="${requestScope.SubscriptionsList}">
            <table class="sub_table_left">
                <tr>
                    <td colspan="2">"c:out value="${s.name}"</td>
                </tr>
                <tr>
                    <td colspan="2">"c:out value="${s.description}"/></td>
                </tr>
                <tr>
                    <td>Period</td>
                    <td>${s.period}</td>
                </tr>
                <tr>
                    <td style="opacity: 100% !important;" colspan="2"><a href="#" class="a-btn-3">
                        <span class="a-btn-3-text">Buy</span>
                        <span class="a-btn-3-slide-text">${s.price}</span>
                        <span class="a-btn-3-icon-right"><span></span></span>
                    </a></td>
                </tr>
            </table>
            </c:forEach>
            <table class="sub_table_right">
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
            </table>
        </div>
        </form>

    </jsp:body>
</mtt:mainlayout>