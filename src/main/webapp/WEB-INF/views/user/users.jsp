<%@ page language="java" contentType = "text/html ; charset = UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link rel = "stylesheet" type = "text/css" href = "/resources/css/commonTable.css"/>
	<link rel = "stylesheet" type = "text/css" href = "/resources/css/users_layout.css"/>
	<link rel="stylesheet" type="text/css" href="/resources/css/page.css"/>
	<script type="text/javascript" src = "/resources/js/jquery-1.9.1.min.js"></script>
    <title>用户管理</title>
    <script type="text/javascript">
    	function changeState(sid,ssign){
    		$.post("store/updateSsignBySid.action",{"sid" : sid , "ssign" : ssign},function(sign){
    			if(sign == 1){
    				window.location.reload();
    			}
    		});
    	}
    </script>
  </head>
  <body style = "background-color : #00BB99;">
  <div class = "left"/>
  	<table class = "solidTable">
  	<tr>
  		<td>用户名</td>
  		<td>姓名</td>
  		<td>生日</td>
  		<td>职业</td>
  		<td>性别</td>
  		<td>操作</td>
  	</tr>
  	<c:forEach items="${users}" var = "everyUser">
  	<tr>
  		<td>${everyUser.username}</td>
		<td>${everyUser.name}</td>
  		<td>${everyUser.birthday}</td>
  		<td>${everyUser.profession}</td>
  		<td>${everyUser.sex}</td>
  		<td align = "center">
  			<a href = "store/findSellerBySid.action?sid" target="showOneSeller">封禁</a>
			<a href = "store/findSellerBySid.action?sid" target="showOneSeller">修改</a>
			<a href = "store/findSellerBySid.action?sid" target="showOneSeller">查看测评记录</a>
  		</td>
  	</tr>
  	</c:forEach>
  </table>
  <div class = "right">
  	<iframe src = "" class = "ifr" name = "showOneSeller"></iframe>
  </div>
  </body>
</html>