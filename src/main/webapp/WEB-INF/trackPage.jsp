<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Track page</title>
</head>
<body>
<div>
    <h2>Отслеживание заказа</h2>
    <jsp:useBean id="travelHistoriesList" scope="request" type="java.util.List"/>
    <jsp:useBean id="travelHistoryService" class="org.example.services.TravelHistoryService"/>
    <table>
        <tr>
            <th>Дата</th>
            <th>Статус</th>
            <th>Адрес</th>
        </tr>
        <c:forEach var="travelHistory" items="${travelHistoriesList}">
        <tr>
            <th>${travelHistory.curTravelDate}</th>
            <th>${travelHistory.curStatus.getValue()}</th>
            <th>${travelHistory.curAddress}</th>
        </tr>
        </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/index">
        <button>Вернуться на главную</button>
    </a>
</div>
</body>
</html>
