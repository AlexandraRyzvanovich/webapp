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
                                <td colspan="2">${subscription.description}</td>
                            </tr>
                            <tr>
                                <td class="sub_table_period">Period</td>
                                <td>${subscription.period}</td>
                            </tr>
                            <tr>
                                <td style="opacity: 100% !important;" colspan="2">
                                    <a href="#" name="${subscription.id}" title="${subscription.price}" onclick="opendialog(this)" class="a-btn-3">
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
            <table cellspacing="0" style="margin-top: 50px;margin-left: 41px; max-width: 95%;">
                <tr>
                    <th>Подписка</th>
                    <th>дата начала</th>
                    <th>цена</th>
                    <th>статус</th>
                </tr>
            <c:forEach var="order" items="${requestScope.ordersList}">
                <tr>
                    <td>${order.subscriptionName}</td>
                    <td>${order.paidDate}</td>
                    <td>${order.amount}</td>
                    <td>${order.orderStatus}</td>
                </tr>
            </c:forEach>
            </table>

        </section>

    </jsp:body>
</mtt:mainlayout>
<script>
    function opendialog(data) {
       document.getElementById("dialog").style.display = '';
       document.querySelector('input[name=subscriptionId]').value = data.name;
        document.querySelector('input[id=value]').value = data.title;
    }

    function closedialog() {
        document.getElementById("dialog").style.display = 'none';
    }
</script>