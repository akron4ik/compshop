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

    <label for="name">Название запчасти</label>
    <input type="text" name="name" id="name" value="${part.name}">
    <label for="need">Необходимость</label>
    <c:if test="${!empty part.name}">
        <c:if test="${part.need == true}">
        <input type="checkbox" name="need" id="need" checked>
        </c:if>
        <c:if test="${part.need == false}">
            <input type="checkbox" name="need" id="need" >
        </c:if>
    </c:if>
    <c:if test="${empty part.name}">
        <input type="checkbox" name="need" id="need" value=true>

    </c:if>
    <label for="count">Количество</label>
    <input type="number" name="count" id="count" value="${part.count}">
    <c:if test="${empty part.name}">
        <input type="submit" value="Add new part">
    </c:if>
    <c:if test="${!empty part.name}">
        <input type="submit" value="Edit part">
    </c:if>

</form>
</body>
</html>
