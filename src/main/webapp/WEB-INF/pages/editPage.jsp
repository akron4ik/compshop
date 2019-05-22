<%--
  Created by IntelliJ IDEA.
  User: aron4ik
  Date: 2019-05-13
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty part.name}">
    <title>Add</title>
    </c:if>
    <c:if test="${!empty part.name}">
        <title>Edit</title>
    </c:if>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<c:if test="${empty part.name}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty part.name}">
    <c:url value="/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty part.name}">
        <input type="hidden" name="id" value="${part.id}">
    </c:if>

<table>
    <c:if test="${!empty part.name}">
        <caption>Редактирование комплектующего</caption>
    </c:if>
    <c:if test="${empty part.name}">
        <caption>Добавление комплетующего</caption>
    </c:if>
    <tr>
        <th>Название</th>
        <th>Необходимость</th>
        <th>Количество</th>
    </tr>
    <tr>

            <td><input type="text" name="name" id="name" value="${part.name}"></td>
            <td> <c:if test="${!empty part.name}">
                <c:if test="${part.need == true}">
                    <input type="checkbox" name="need" id="need" checked>
                </c:if>
                <c:if test="${part.need == false}">
                    <input type="checkbox" name="need" id="need" >
                </c:if>
            </c:if>
                <c:if test="${empty part.name}">
                    <input type="checkbox" name="need" id="need" value=true>

                </c:if></td>
            <td><input type="number" name="count" id="count" value="${part.count}">
                <c:if test="${empty part.name}">
                    <input type="submit" value="Добавить">
                </c:if>
                <c:if test="${!empty part.name}">
                    <input type="submit" value="Сохранить">
                </c:if></td>



    </tr>
</table>

</form>
</body>
</html>
