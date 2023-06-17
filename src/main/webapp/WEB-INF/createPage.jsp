<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create page</title>
</head>
<body>
<div>
    <h2>Добавление заказа</h2>
    <form method="post" action="${pageContext.request.contextPath}/create">
        <label for="address">address:</label>
        <input type="text" id="address" name="address">
        <br>
        <label for="deliveryType">delivery type:</label>
        <input type="text" id="deliveryType" name="deliveryType">
        <br>
        <div>
            <input type="submit" value="Создать заказ">
        </div>
    </form>
    <a href="${pageContext.request.contextPath}/index">
        <button>Вернуться на главную</button>
    </a>
</div>
</body>
</html>
