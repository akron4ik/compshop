<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aron4ik
  Date: 2019-05-17
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Запчасть</title>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>

<table>
    <caption>Результат поиска</caption>
    <c:if test="${empty part.name}">
        <caption>К сожалению такой детали нет!</caption>
    </c:if>

<c:if test="${!empty part.name}">
    <tr>
        <th>Название</th>
        <th>Необходимость</th>
        <th>Количество</th>
    </tr>
</c:if>
    <tr>
        <c:if test="${!empty part.name}">
            <td>${part.name}</td>
            <td> <c:out value="${part.need == true ? 'Да':'Нет'}"/></td>
            <td>${part.count}</td>
            <td>
                <a href="/edit/${part.id}">edit</a>
                <a href="/delete/${part.id}">delete</a>
            </td>
        </c:if>

    </tr>

</table>
</body>
</html>
