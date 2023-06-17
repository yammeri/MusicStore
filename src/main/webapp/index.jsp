<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home page</title>
</head>
<body>
<div>
    <form method="get" action="${pageContext.request.contextPath}/track">
        <label for="orderId">Номер заказа:</label>
        <input type="text" id="orderId" name="orderId">
        <br>
        <div>
            <input type="submit" value="Отследить заказ">
        </div>
    </form>

    <a href="${pageContext.request.contextPath}/create">
        <button>Создать заказ</button>
    </a>
</div>
</body>
</html>
