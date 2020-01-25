<%@tag language="java" description="Overall Page template" pageEncoding="UTF-8" %>
<%@ attribute name="main" rtexprvalue="true" %>
<html>
<head>
    <style>
        <%@include file="/resources/css/main.css"%>
        <%--        <%@include file="/resources/css/util.css"%>--%>
        .content{
            margin-top: 90px;
        }

    </style>

    <title>${title}</title>
</head>
<body>

<div id="wrapper">
    <jsp:include page="/WEB-INF/views/shared/header.jsp"></jsp:include>
    <div class="content">
        <jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>
        <jsp:doBody/>
    </div>
</div>
</body>
</html>
