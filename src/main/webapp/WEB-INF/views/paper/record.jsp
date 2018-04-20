<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>问卷</title>
</head>
<body>
    <center>${recordBean.name}</center>
    <br/>
    <p>${recordBean.guide}</p>
    <br/>
<fieldset>
    <legend>开始测评</legend>
    <ol id="questions">
        <c:forEach items="${recordBean.questionRecordList}" var="question">
            <li type="0">
                <p>${question.name}</p>
                <ol type="A">
                    <c:forEach items="${question.optionBeanList}" var="option">
                        <li>
                            ${option.content}
                                &nbsp;&nbsp;
                            <c:if test="${option.index == question.selectedOption }">
                                <img src="/resources/img/sign-check-icon.png" style="width: 16px;height: 16px"/>
                                <font style="color:darkred">得分${question.mark}</font></c:if>
                        </li>
                    </c:forEach>
                </ol>
            </li>
        </c:forEach>
    </ol>
</fieldset>
<br/>
    <hr/>
    <a href="/${recordBean.conclusionFilePath}">点击查看测评结果</a>
</body>
</html>
