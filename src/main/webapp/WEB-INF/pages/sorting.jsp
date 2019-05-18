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
<table>
    <tr>
        <th>Название</th>
        <th>Необходимость</th>
        <th>Количество</th>
    </tr>
<c:forEach var="part" items="${sortParts}">
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
</body>
</html>
