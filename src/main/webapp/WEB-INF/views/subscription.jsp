<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="mtt" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="locale"/>

<mtt:mainlayout>
    <jsp:attribute name="main"></jsp:attribute>
    <jsp:body>
        <section>
            <h1 style="color: #E1D070;text-align: center;margin-bottom: 3%;"><fmt:message key="subscription.tableHeaderSummary"/></h1>
            <div class="sub_div">
                <table class="sub_table_left">
                    <tr>
                        <td>Light</td>
                        <td><fmt:message key="subscription.lightDescription"/></td>
                    </tr>
                    <tr>
                        <td>Medium</td>
                        <td><fmt:message key="subscription.mediumDescription"/></td>
                    </tr>
                    <tr>
                        <td>Hard</td>
                        <td><fmt:message key="subscription.hardDescription"/></td>
                    </tr>
                    <tr>
                        <td>Optimal</td>
                        <td><fmt:message key="subscription.optimalDescription"/></td>
                    </tr>
                </table>
            </div>
                <h1 style="color: #E1D070;text-align: center;margin-bottom: 3%;"><fmt:message key="subscription.tableHeaderBuySubscriptions"/></h1>
                <div class="sub_div">
                    <c:set var="s" value="${requestScope.subscriptionsList}" scope="request"></c:set>
                    <c:forEach var="subscription" items="${requestScope.subscriptionsList}">
                        <table class="sub_table_left">
                            <tr>
                                <td colspan="2">${subscription.name}</td>
                            </tr>
                            <tr>
                                <td class="sub_table_period"><fmt:message key="subscription.period"/> </td>
                                <td>${subscription.period}</td>
                            </tr>
                            <tr>
                                <td style="opacity: 100% !important;" colspan="2">
                                    <a href="#" name="${subscription.id}" title="${subscription.price}" onclick="opendialog(this)" class="a-btn-3">
                                    <span class="a-btn-3-text">Buy</span>
                                    <span class="a-btn-3-slide-text"><fmt:formatNumber value="${subscription.price}" groupingUsed="true" pattern="###.#$"  type="currency"/></span>
                                    <span class="a-btn-3-icon-right"></span>
                                </a>
                                </td>
                            </tr>
                        </table>
                    </c:forEach>
                </div>
            </form>
            <c:if test="${requestScope.ordersList.size() > 0}">
                <table cellspacing="0" style="margin-top: 50px;margin-left: 41px; max-width: 95%;">
                    <tr>
                        <th><fmt:message key="table.subscriptionName"/></th>
                        <th><fmt:message key="table.paidDate"/></th>
                        <th><fmt:message key="table.amountPaid"/></th>
                        <th><fmt:message key="table.orderStatus"/></th>
                    </tr>
                    <c:forEach var="order" items="${requestScope.ordersList}">
                        <tr>
                            <td>${order.subscriptionName}</td>
                            <td><fmt:parseDate value="${order.paidDate}" pattern="y-M-dd"/></td>
                            <td><fmt:formatNumber value="${order.amount}"  groupingUsed="true" pattern="###.#$"  type="currency" /></td>
                            <td>${order.orderStatus}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
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