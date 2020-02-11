<%@tag language="java" description="Overall Page template" pageEncoding="UTF-8" %>
<%@ attribute name="main" rtexprvalue="true" %>
<html>
<head>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet"/>
    <style>
        <%@include file="/resources/css/main.css"%>
        body{
            background-image: url("/resources/images/main.jpg");
            background-size: cover;
        }


    </style>
    <script type="text/javascript">
        <%@include file="/resources/js/main.js"%>
    </script>

    <title>${title}</title>
</head>
<body>

<div id="wrapper">
    <jsp:include page="/WEB-INF/views/shared/header.jsp"></jsp:include>
    <div class="content">
        <jsp:include page="/WEB-INF/views/shared/menu.jsp"></jsp:include>
        <jsp:doBody/>
    </div>
</div>
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
                    <div class="col-50">
                        <label for="value">Amount</label>
                        <input type="text" readonly id="value" value="">
                    </div>
                    <input hidden name="orderStatus" value="PROCESSED"/>
                    <input hidden name = "subscriptionId" value=""/>
                </div>
            </div>
            <input type="submit" class="bot1" value="Buy"/>
        </form>
    </div>
</div>
</body>
</html>
