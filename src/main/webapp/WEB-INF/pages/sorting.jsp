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
</head>
<body>

<form method="get" action="/sort">
    <p><select name="sort" size="1">
        <option value="1" >All</option>
        <option value="2">True</option>
        <option value="3">False</option>
    </select>
        <input type="submit" value="Sorting"></p>
</form>

<table>
    <tr>
        <th>Название</th>
        <th>Необходимость</th>
        <th>Количество</th>
    </tr>
    <c:forEach var="part" items="${soPa}">
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

<c:forEach begin="1" end="${pagCount}" step="1" varStatus="i">
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
</body>
</html>
