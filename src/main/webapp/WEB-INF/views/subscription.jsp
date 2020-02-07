<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mtt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="http://code.jquery.com/jquery-2.0.2.min.js"></script>
<mtt:mainlayout>
    <jsp:attribute name="main"></jsp:attribute>
    <jsp:body>
        <section>
            <form method="GET" action="subscriptions">
                <input type="hidden" name="command" value="getAvailableSubscriptions">
                <h1 style="color: #E1D070;text-align: center;margin-bottom: 3%;">Your Subscription</h1>
                <div class="sub_div">
                    <c:set var="s" value="${requestScope.subscriptionsList}" scope="request"></c:set>
                    <c:forEach var="subscriprion" items="${requestScope.subscriptionsList}">
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
                                <td style="opacity: 100% !important;" colspan="2"><a href="#" onclick="opendialog()"
                                                                                     class="a-btn-3">
                                    <span class="a-btn-3-text">Buy</span>
                                    <span class="a-btn-3-slide-text">${subscriprion.price}</span>
                                    <span class="a-btn-3-icon-right"><span></span></span>
                                </a></td>
                            </tr>
                        </table>
                    </c:forEach>
                </div>
            </form
            <table cellspacing="0">
                <tr>
                    <th>Подписка</th>
                    <th>дата начала</th>
                    <th>цена</th>
                    <th>статус</th>
                </tr>
            <c:forEach var="order" items="${requestScope.ordersList}">
                <tr>
                    <td>${order.subscriptionId}</td>
                    <td>${order.paidDate}</td>
                    <td>${order.amount}</td>
                    <td>${order.orderStatus}</td>
                </tr>
            </c:forEach>
            </table>
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
        </section>
    </jsp:body>
</mtt:mainlayout>
<script>
    $(document).ready(function () {
        $("#dialog").hide(); //скрываем окно при загрузке страница
    });

    function opendialog() {
        $("#dialog").fadeIn(); //плавное появление блока
    }

    function closedialog() {
        $("#dialog").fadeOut(); //плавное исчезание блока
    }
</script>