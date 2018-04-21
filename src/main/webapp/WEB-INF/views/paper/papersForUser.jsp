<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/19
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>问卷中心</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/commonTable.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/users_layout.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/page.css"/>
    <script type="text/javascript" src="/resources/js/jquery-1.9.1.min.js"></script>
</head>
<body>
<table class="solidTable">
    <tr>
        <td>问卷名称</td>
        <td>创建时间</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${papers}" var="everyPaper">
        <c:if test="${!everyPaper.disable}">
        <tr>
            <td>${everyPaper.name}</td>
            <td>${everyPaper.newTime}</td>
            <td align="center">
                <a href="/paper/${everyPaper.id}" target="_blank">开始测评</a>
            </td>
        </tr>
        </c:if>
    </c:forEach>
</table>
<br/>
&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" onClick="location.href='/paper/add.jsp'" value="添加问卷"/>
</body>
</html>
