<%@ page language="java" contentType="text/html ; charset = UTF-8"
	pageEncoding="UTF-8" errorPage="../../../error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>心理测评系统</title>
	<link href="../../../bootstrap/css/bootstrap.min.css" rel="stylesheet" />
	<link href="/resources/css/main.css" type="text/css" rel="stylesheet" />
	<link href="/resources/css/adm.css" type="text/css" rel="stylesheet" />
	<script src="/resources/js/jquery-1.9.1.min.js"></script>
	<script src="../../../bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="header">
		<label class="logo-title">心理测评中心</label>
		<ul class="inline">
			<li>&nbsp;&nbsp;欢迎您,${currentUser.name}</li>
			<li>
				<img src="/resources/img/sellMain_images/32/200.png" />&nbsp;&nbsp;
				<a class="loginout" href="../login.jsp">退出</a>
			</li>
		</ul>
	</div>

	<div class="nav">
		<ul class="breadcrumb">
			<li><img src="/resources/img/sellMain_images/32/5025_networking.png" /></li>
			<li><a href="javascipt:void(0)" id = "home">首页</a> <span class="divider">&gt;&gt;</span></li>
			<li class="active"></li>
		</ul>
	</div>

	<div class="container-fluid content">
		<div class="row-fluid">
			<div class="span2 content-left" style="overflow-y:hidden">
				<div class="accordion">
					<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne"> 
								<img class="left-icon" src="/resources/img/sellMain_images/32/410.png" />
								<span class="left-title">应用中心</span>
							</a>
						</div>
						<div id="collapseOne" class="accordion-body collapse in">
							<div class="accordion-inner"  id = "paperInfo">
								<img class="left-icon-child" src="/resources/img/sellMain_images/32/161.png" />
								<span class="left-body"> 心理测评</span>
							</div>
							<div class="accordion-inner" id = "recordInfo">
								<img class="left-icon-child" src="/resources/img/sellMain_images/32/449.png" />
								<span class="left-body"> 测评记录</span>

							</div>
						</div>

						<div class="accordion-heading">
							<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseThree"> 
								<img class="left-icon" src="/resources/img/sellMain_images/32/4992_user.png" />
								<span class="left-title">个人信息</span>
							</a>
						</div>
						<div id="collapseThree" class="accordion-body collapse in">
							<div class="accordion-inner" id = "userInfo">
								<img class="left-icon-child" src="/resources/img/sellMain_images/32/469.png" />
								<span class="left-body"> 信息修改</span>
							</div>
						</div>

					</div>
				</div>
			</div>
			<div class="span10 content-right" style = "overflow-y:hidden">

				<iframe src="/jsp/home.jsp" class="iframe" id = "ifr"></iframe>

			</div>
		</div>
	</div>
	<div class="clearfix"></div>
	<div class="foot"></div>
	<script>
		$("#userInfo").click(function(){
		$("#ifr").attr("src","/user/${currentUser.username}");
		});

		$("#recordInfo").click(function(){
		$("#ifr").attr("src","/record/query?username=${currentUser.username}");
		});


		$("#paperInfo").click(function(){
		$("#ifr").attr("src","/paper/query/allForUser");
		});

	</script>
	<script src="/resources/js/selm.js"></script>
</body>
</html>

