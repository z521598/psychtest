<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>问卷</title>
</head>
<body>
<form action="/paper/add" method="post" enctype="multipart/form-data">
    <center>${paperBean.name}</center>
    <br/>
    <p>${paperBean.guide}</p>
    <br/>
<fieldset>
    <legend>开始测评</legend>
    <ol id="questions">
        <c:forEach items="${paperBean.questions}" var="question">
            <li type="0" id="question0">
                <p>${question.name}</p>
                <ol type="A" id="${question.index}">
                    <c:forEach items="${question.optionBeanList}" var="option">
                        <li>
                            <input type="radio" name="${question.index}" value="${option.index}">${option.content}
                        </li>
                    </c:forEach>
                </ol>
            </li>
        </c:forEach>
    </ol>
</fieldset>
<br/>
<hr/>
    <center>
        <input type="submit" value="提交测评" id="submit"/>
    </center>
</form>
</body>
</html>
