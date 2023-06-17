<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error page</title>
</head>
<body>
<div>
    <h1>
        <%= request.getSession().getAttribute("error")%>
    </h1>
    <a href="${pageContext.request.contextPath}/index">
        <button>Вернуться на главную</button>
    </a>
</div>
</body>
</html>
