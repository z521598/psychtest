<%@ page language="java" contentType = "text/html ; charset = UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>首页</title>
    <script type="text/javascript">

    </script>
  </head>
  <body style="background-color:#00BB99;margin-top:20px;margin-left:20px">
	  <center>
		  <h3 class="text-warning text-center" style = "color : #ffffff">
			  欢迎您
		  </h3>
	  </center>
  </body>
</html>