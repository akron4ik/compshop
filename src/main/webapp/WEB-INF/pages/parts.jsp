<%--
  Created by IntelliJ IDEA.
  User: aron4ik
  Date: 2019-05-13
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>PARTS</title>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<h2>Parts</h2>

<form method="get" action="/check-part">
    <input type="text" name="name" id="name" >
    <button>Search</button>
</form>

    <form method="get" action="/">
        <p><select name="sort" size="1">
            <option value="1">All</option>
            <option value="2">True</option>
            <option value="3">False</option>
        </select>
            <input type="submit" value="Sorting"></p>
    </form>





<table>


    <tr>
        <th>Название запчасти</th>
        <th>Необходимость</th>
        <th>Количество</th>
    </tr>
    <c:forEach  var="part"  items="${sortParts}">

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
        <th>Можно собрать</th>
        <th>${countOf}</th>
        <th>Компьютеров</th>
    </tr>
</table>

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
