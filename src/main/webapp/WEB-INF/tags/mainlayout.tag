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
</body>
</html>
