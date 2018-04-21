<%@ page language="java" contentType="text/html ; charset = UTF-8" pageEncoding="UTF-8" errorPage="../../../error.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>心理测评系统后台管理</title>
	<link href="../../../bootstrap/css/bootstrap.min.css" rel="stylesheet" />
	<link href="/resources/css/main.css" type="text/css" rel="stylesheet" />
	<link href="/resources/css/adm.css" type="text/css" rel="stylesheet" />
	<script src="/resources/js/jquery-1.9.1.min.js"></script>
	<script src="../../../bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="header">
		<label class="logo-title">心理测评系统管理中心</label>
		<ul class="inline">
			<li>&nbsp;&nbsp;欢迎您,尊贵的管理员</li>
		</ul>
	</div>

	<div class="nav">
		<ul class="breadcrumb">
			<li><img src="/resources/img/sellMain_images/32/5025_networking.png" /></li>
			<li>
				<a href="javascipt:void(0)" id = "home">首页</a> 
				<span class="divider">&gt;&gt;</span>
			</li>
			<li class="active" id = "active"></li>
		</ul>
	</div>


	<div class="container-fluid content">
		<div class="row-fluid">
			<div class="span2 content-left" style="overflow-y:scroll">		<!-- 滚动条 -->
				<div class="accordion">
					<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne"> 
								<img class="left-icon" src="/resources/img/sellMain_images/32/410.png" />
								<span class="left-title">问卷管理</span>
							</a>
						</div>
						<div id="collapseOne" class="accordion-body collapse in">
							<div class="accordion-inner" id = "paper">
								<img class="left-icon-child" src="/resources/img/sellMain_images/32/261.png" />
								<span class="left-body"> 问卷管理</span>
							</div>
						</div>
						 
						<div class="accordion-heading">
							<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo"> 
							<img class="left-icon" src="/resources/img/sellMain_images/32/469.png" />
							<span class="left-title">信息管理</span>
							</a>
						</div>
						<div id="collapseTwo" class="accordion-body collapse in">
							<div class="accordion-inner"  id = "users">
								<img class="left-icon-child" src="/resources/img/sellMain_images/32/4992_user.png" />
								<span class="left-body"> 用户信息</span>
							</div>
							<div class="accordion-inner" id = "records">
								<img class="left-icon-child"
									src="/resources/img/sellMain_images/32/20130508035646751_easyicon_net_32.png" /><span
									class="left-body"> 测评信息</span>
							</div>
						</div>
						
						<div class="accordion-heading">
							<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseFour"> 
							<img class="left-icon" src="/resources/img/sellMain_images/32/233.png" />
							<span class="left-title">账户安全</span>
							</a>
						</div>
						<div id="collapseFour" class="accordion-body collapse in">
							<div class="accordion-inner" id = "updatePassword">
								<img class="left-icon-child" src="/resources/img/sellMain_images/32/243.png" />
								<span class="left-body"> 修改密码</span>
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
	<script src="/resources/js/adm.js"></script>
	<!-- 实现非关键js代码与jsp分离 -->
</body>
</html>

