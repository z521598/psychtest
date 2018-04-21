<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/resources/css/commonTable.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/users_layout.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/page.css"/>
    <script type="text/javascript" src="/resources/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
        function test() {

            return false;
        }
    </script>
    <title>问卷</title>
</head>
<body>
<form action="/record/submit/${paperBean.id}" method="post" enctype="multipart/form-data">
    <center>${paperBean.name}</center>
    <br/>
    <p>${paperBean.guide}</p>
    <br/>
    <fieldset>
        <legend>开始测评</legend>
        <ol id="questions">
            <c:forEach items="${paperBean.questions}" var="question">
                <li type="0">
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
        <input type="submit" value="提交测评" id="submit"/><label id="msg"></label>
    </center>
</form>
</body>
</html>
