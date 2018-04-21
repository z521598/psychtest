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
    <script type="text/javascript">
        function disable(paperId, disable) {
            $.get("/paper/disable?paperId=" + paperId + "&disable=" + disable, function (sign) {
                window.location.reload();
            });
        }
    </script>
</head>
<body>
<table class="solidTable">
    <tr>
        <td>问卷名称</td>
        <td>创建时间</td>
        <td>参考文档</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${papers}" var="everyPaper">
        <tr>
            <td>${everyPaper.name}</td>
            <td>${everyPaper.newTime}</td>
            <td><a href="/${everyPaper.conclusionFilePath}">点击下载查看</a></td>
            <td align="center">
                <c:if test="${everyPaper.disable}">
                    <a href="javascript:void(0)" onClick="disable(${everyPaper.id},false)">
                        启用
                    </a>
                </c:if>
                <c:if test="${!everyPaper.disable}">
                    <a href="javascript:void(0)" onClick="disable(${everyPaper.id},true)"/>
                    禁用
                    </a>
                </c:if>
                <a href="update/${everyPaper.id}">修改</a>
                <a href="delete/${everyPaper.id}" onclick="">删除</a>
                <a href="${everyPaper.id}/file" target="_blank">导出问卷</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br/>
&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" onClick="location.href='/paper/add.jsp'" value="添加问卷"/>
</body>
</html>
