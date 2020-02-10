<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mtt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<mtt:mainlayout>
    <jsp:attribute name="main"></jsp:attribute>
    <jsp:body>
        <section>
                <h1 style="color: #E1D070;text-align: center;margin-bottom: 3%;">Your Subscription</h1>
                <div class="sub_div">
                    <c:set var="s" value="${requestScope.subscriptionsList}" scope="request"></c:set>
                    <c:forEach var="subscription" items="${requestScope.subscriptionsList}">
                        <table class="sub_table_left">
                            <tr>
                                <td colspan="2">${subscription.name}</td>
                            </tr>
                            <tr>
                                <td colspan="2">${subscription.description}/></td>
                            </tr>
                            <tr>
                                <td class="sub_table_period">Period</td>
                                <td>${subscription.period}</td>
                            </tr>
                            <tr>
                                <td style="opacity: 100% !important;" colspan="2">
                                    <a href="#" name="${subscription.id}" onclick="opendialog(this)" class="a-btn-3">
                                    <span class="a-btn-3-text">Buy</span>
                                    <span class="a-btn-3-slide-text">${subscription.price}</span>
                                    <span class="a-btn-3-icon-right"></span>
                                </a>
                                </td>
                            </tr>
                        </table>
                    </c:forEach>
                </div>
            </form>
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

            <div class="back-dialog" id="dialog" style="display:none ">
                <div class="dialog-content">
                    <div class="dialog-title">
                        <span>Введите данные для оплаты</span>
                        <a class='close-dialog' href='javascript: closedialog()'></a>
                    </div>
                    <form method="POST" action="subscriptions" >
                        <input type="hidden" name="command" value="buySubscription" />
                        <div class="col-50">
                            <div class="icon-container">
                                <i class="fa fa-cc-visa" style="color:navy;"></i>
                                <i class="fa fa-cc-amex" style="color:blue;"></i>
                                <i class="fa fa-cc-mastercard" style="color:red;"></i>
                                <i class="fa fa-cc-discover" style="color:orange;"></i>
                            </div>
                            <label for="cname">Name on Card</label>
                            <input type="text" id="cname" placeholder="John More Doe">
                            <label for="ccnum">Credit card number</label>
                            <input type="text" id="ccnum"  placeholder="1111-2222-3333-4444">
                            <label for="expmonth">Exp Month</label>
                            <input type="text" id="expmonth" placeholder="September">
                            <div class="row">
                                <div class="col-50">
                                    <label for="expyear">Exp Year</label>
                                    <input type="text" id="expyear" placeholder="2018">
                                </div>
                                <div class="col-50">
                                    <label for="cvv">CVV</label>
                                    <input type="text" id="cvv" placeholder="352">
                                </div>
                                <input hidden name="orderStatus" value="PROCESSED"/>
                                <input hidden name = "subscriptionId" value=""/>
                            </div>
                        </div>
                        <input type="submit" class="bot1" value="Buy"/>
                    </form>
                </div>
            </div>
        </section>
    </jsp:body>
</mtt:mainlayout>
<script>

    function opendialog(data) {
       document.getElementById("dialog").style.display = '';
       document.querySelector('input[name=subscriptionId]').value = data.name;
    }

    function closedialog() {
        document.getElementById("dialog").style.display = 'none';
    }
   /* function buy() {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            xhttp.open("post", "controller?command=buySubscription", true);
            xhttp.send();
        }
    }*/
</script>