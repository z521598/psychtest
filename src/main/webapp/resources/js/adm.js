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
$("#paper").click(function(){
	$("#ifr").attr("src","paper/all");
});
$("#records").click(function(){
	$("#ifr").attr("src","record/all");
});
$("#updatePassword").click(function(){
	$("#ifr").attr("src","jsp/updatePassword.jsp");
});
$("#users").click(function(){
	$("#ifr").attr("src","user/all");
});
$("#home").click(function(){
	$("#ifr").attr("src","jsp/home.jsp");
	//修改导航栏的文字信息
	$(".active").html("");
});



