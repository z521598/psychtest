$(function () {
    $(".content-left,.content-right").height($(window).height() - 130);
});
$(".accordion-inner").click(function () {
    $(".active").html($(this).find(".left-body").text());
});
$(window).resize(function () {
    $(".content-left,.content-right").height($(window).height() - 130);
});
//以下为导航控制跳转的js实现
$("#addAdmin").click(function(){
	$("#ifr").attr("src","adminNav/addAdmin.jsp");
});
$("#paper").click(function(){
	$("#ifr").attr("src","paper/all");
});
$("#evaluate").click(function(){
	$("#ifr").attr("src","comment/findAll.action");
});
$("#goods").click(function(){
	$("#ifr").attr("src","goods/findAllGoods.action");
});
$("#information").click(function(){
	$("#ifr").attr("src","orders/findInfo.action");
});
$("#journalAccount").click(function(){
	$("#ifr").attr("src","adminNav/journalAccount.jsp");
});

$("#seller_info").click(function(){
	$("#ifr").attr("src","adminNav/seller_info.jsp");
});
$("#records").click(function(){
	$("#ifr").attr("src","record/all");
});
$("#updatePassword").click(function(){
	$("#ifr").attr("src","adminNav/updatePassword.jsp");
});
$("#users_info").click(function(){
	$("#ifr").attr("src","adminNav/users_info.jsp");
});
$("#users").click(function(){
	$("#ifr").attr("src","user/all");
});
$("#home").click(function(){
	$("#ifr").attr("src","adminNav/home.jsp");
	//修改导航栏的文字信息
	$(".active").html("");
});



