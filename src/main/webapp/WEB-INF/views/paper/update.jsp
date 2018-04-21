<%@ page import="com.jlu.paper.bean.PaperBean" %>
<%@ page import="com.jlu.paper.bean.QuestionBean" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html ; charset = UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <base href="<%=basePath%>"/>
        <script type="text/javascript" src = "/resources/js/jquery-1.9.1.min.js"></script>
        <script type="text/javascript">
            // 问题的索引
            var index = <%=((PaperBean)request.getAttribute("paperBean")).getQuestions().size() -1%>;
            // 选项索引
            var optionIndexs = [];
            <%
                List<QuestionBean> questionBeanList = ((PaperBean)request.getAttribute("paperBean")).getQuestions();
                for(int i=0;i<questionBeanList.size();i++){
                    %>
                optionIndexs[<%=i%>] = <%=questionBeanList.get(i).getOptionsNumber()-1%>;
            <%
                }
            %>
            function addOption(i){
            if(optionIndexs[i] == undefined){
            optionIndexs[i] = 1;
            }
            console.log(i);
            var ol = $("#option"+i);
            var newLi =
            '<li>\
            <input type="text" value="请输入选项内容" name="question'+i+'-option'+optionIndexs[i]+'-content"/>\
            &nbsp;&nbsp;\
            <input type="text" value="请输入分数" name="question'+i+'-option'+optionIndexs[i]+'-mark"/>分\
            &nbsp;&nbsp;\
            <input type="button" value="删除此选项" onClick="delOption(this)">\
        </li>'
            ol.append(newLi);
            optionIndexs[i] = optionIndexs[i] + 1;

            }
            function addQuestion(){
            var ol = $("#question"+index);
            index++;
            var newLi =
            '<li type="1" id="question'+index+'">\
            <input type="text" value="请输入问题内容" name="question'+index+'" style="width:600px"/>\
            <ol type="A" id="option'+index+'">\
                <li>\
                    <input type="text" value="请输入选项内容" name="question'+index+'-option0-content"/>\
                    &nbsp;&nbsp; \
                    <input type="text" value="请输入分数" name="question'+index+'-option0-mark"/>分\
                    &nbsp;&nbsp; \
                    <input type="button" value="删除此选项" onClick="delOption(this)">\
                    \
                </li>  \
            </ol> \
            <input type="button" value="添加选项" onClick="addOption('+index+')"/> \
        </li>'
            ol.append(newLi);
            }
            function delOption(op){
            op.parentNode.remove();
            }
        </script>
    </head>
    <body>
        <form action="/paper/update/${paperBean.id}/submit" method="post" enctype="multipart/form-data">
            问卷标题：
            <input type="text" name="name" value="${paperBean.name}"/>
            <br/>
            <br/>
            引导语：<br/>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <textarea rows="5" cols="50" name="guide">${paperBean.guide}</textarea>
            <br/>
            <br/>
            <fieldset>
                <legend>问题区域</legend>
                    <ol id="questions">
                        <c:forEach items="${paperBean.questions}" var="questionBean" varStatus="qstatus">
                        <li type="0" id="question${qstatus.index}">
                            <input type="text" value="${questionBean.name}" style="width:600px" name="question${qstatus.index}"/>
                            <ol type="A" id="option${qstatus.index}">
                            <c:forEach items="${questionBean.optionBeanList}" var="optionBean" varStatus="ostatus">
                                    <li>
                                        <input type="text" value="${optionBean.content}" name="question${qstatus.index}-option${ostatus.index}-content"/>
                                        &nbsp;&nbsp;
                                        <input type="text" value="${optionBean.mark}" name="question${qstatus.index}-option${ostatus.index}-mark"/>分
                                        &nbsp;&nbsp;
                                        <input type="button" value="删除此选项" onClick='delOption(this)'/>
                                    </li>
                            </c:forEach>
                            </ol>
                            <input type="button" value="添加选项" onClick='addOption(${qstatus.index})'/>
                        </li>
                        </c:forEach>
                    </ol>
                <input type="button" value="添加问题" onClick="addQuestion()"/>
            </fieldset>
            <br/>
            用户参考文档：<input type="file" name="conclusionFilePath"/>
            <hr/>
            <input type="submit" value="提交" id="submit"/>
        </form>
    </body>
</html>