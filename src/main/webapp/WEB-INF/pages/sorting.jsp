<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aron4ik
  Date: 2019-05-18
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sorting</title>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>

<form method="get" action="/sort" class="sorting">
    <p><select name="sort" size="1">
        <option value="1">Все комплектующие</option>
        <option value="2">Необходимые комплектующие</option>
        <option value="3">Необязательные комплектующие</option>
    </select>
        <input type="submit" value="Сортировка"></p>
</form>
<form method="get" action="/check-part" class ="search">
    <input type="text" name="name" id="name" placeholder="Video card">
    <button>Поиск</button>
</form>

<c:url value="/add" var="add"/>
<input class="adding" type="button" value = "Добавь запчасть" onclick='location.href="${add}"'>

<table>
    <caption>Таблица компьютерных комплектующих</caption>
    <tr>
        <th>Название запчасти</th>
        <th>Необходимость</th>
        <th>Количество</th>
        <th>Действие</th>
    </tr>
    <c:forEach var="part" items="${sortingParts}">
    <tr>
        <td>${part.name}</td>
        <td> <c:out value="${part.need == true ? 'Yes':'No'}"/></td>
        <td>${part.count}</td>
        <td>
            <a href="/edit/${part.id}">edit</a>
            <a href="/delete/${part.id}">delete</a>
        </td>
    </tr>
</c:forEach>
</table>
<table>
    <tr>
        <th>Всего комплектующих</th>
        <th>${partCount}</th>
        <th>шт.</th>
    </tr>
</table>


<table>
    <tr>
        <th>Можно собрать</th>
        <th>${countOfcomps}</th>
        <th>Компьютеров</th>
    </tr>
</table>
<div id="paging">
<c:forEach begin="1" end="${pageCount}" step="1" varStatus="i">
    <c:if test="${sort == 2}">
    <c:url value="/sort?sort=2" var="url">
        <c:param name="page" value="${i.index}"/>
    </c:url>
    <a href="${url}">${i.index}</a>
    </c:if>
    <c:if test="${sort == 1}">
        <c:url value="/sort?sort=1" var="url">
            <c:param name="page" value="${i.index}"/>
        </c:url>
        <a href="${url}">${i.index}</a>
    </c:if>
    <c:if test="${sort == 3}">
        <c:url value="/sort?sort=3" var="url">
            <c:param name="page" value="${i.index}"/>
        </c:url>
        <a href="${url}">${i.index}</a>
    </c:if>


</c:forEach>
    </div>
</body>
</html>
