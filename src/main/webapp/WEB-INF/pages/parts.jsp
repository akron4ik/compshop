<%--
  Created by IntelliJ IDEA.
  User: aron4ik
  Date: 2019-05-13
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>PARTS</title>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<h2>Parts</h2>
<table>
    <tr>
        <th>Название запчасти</th>
        <th>Необходимость</th>
        <th>Количество</th>
    </tr>
    <c:forEach var="part" items="${partsList}">
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
<h2>Count</h2>
<h1>"${countOf}"</h1>
<h2>Add</h2>
<c:url value="/add" var="add"/>
<a href="${add}">Add new Part</a>

<c:forEach begin="1" end="${pagesCount}" step="1" varStatus="i">
    <c:url value="/" var="url">
        <c:param name="page" value="${i.index}"/>
    </c:url>
    <a href="${url}">${i.index}</a>
</c:forEach>

</body>
</html>
