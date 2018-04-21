<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测评记录中心</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/commonTable.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/users_layout.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/page.css"/>
    <script type="text/javascript" src="/resources/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
        function del(recordId) {
            $.ajax({
                url: "/record/" + recordId,
                type: 'DELETE',
                success: function(result) {
                    window.location.reload();
                }
            });
        }
    </script>
</head>
<body>
<form action="/record/query">
    &nbsp;&nbsp;&nbsp;&nbsp;
    <input type="text" name="username"/>&nbsp;&nbsp;
    <input type="submit" value="按照用户名称查询"/>
</form>
<hr/>
<table class="solidTable">
    <tr>
        <td>问卷名称</td>
        <td>用户名称</td>
        <td>测评时间</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${records}" var="everyRecord">
        <tr>
            <td>${everyRecord.name}</td>
            <td>${everyRecord.username}</td>
            <td>${everyRecord.newTime}</td>
            <td align="center">
                <a href="javascript:void(0)" onclick="del(${everyRecord.id})">删除</a>
                <a href="store/findSellerBySid.action?sid">导出记录</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br/>
</body>
</html>
