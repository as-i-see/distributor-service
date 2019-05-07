<%--
  Created by IntelliJ IDEA.
  User: asisee
  Date: 20.04.19
  Time: 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>LOLOLO</h1>
    <c:set var="role" value="${sessionScope.get('role')}"/>
    <c:if test="${role == null}">
        <c:redirect url="authorize.html"/>
    </c:if>
    <c:choose>
        <c:when test="${role=='admin'}">

        </c:when>
        <c:otherwise>

        </c:otherwise>

    </c:choose>
</body>
</html>
