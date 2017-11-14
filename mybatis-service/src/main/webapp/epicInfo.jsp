<%--
  Created by IntelliJ IDEA.
  User: fisherman
  Date: 2017/11/10
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>史诗详情</title>
    <style type="text/css">
        #centr {
            width: 1250px;
            height: 200px;
            position: absolute;
            left: 15%;
            top: 20%;
            margin: -100px 0 0 -150px;
        }

    </style>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());//以服务器的路径为标准，http://localhost:3306
    %>
    <script type="text/javascript" src="${APP_PATH}/static/js/jquery-3.2.1.min.js"></script>
    <link href="${APP_PATH}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="${APP_PATH}/static/bootstrap/js/bootstrap.min.js"></script>
    <link rel='stylesheet' href='${APP_PATH}/static/bootstrap/css/bootstrap-datetimepicker.css'/>
</head>


<body>
<div id="centr">

    <h3>问题详情：</h3>

    类型： ${epicInfo.questionType}
    <br>
    <br>
    优先级：${epicInfo.priority}
    <br>
    <br>
    状态：${epicInfo.status}
    <br>
    <br>
    Epic Name：${epicInfo.projectName}
    <br>
    <br>
    业务部门：${epicInfo.operationDept}
    <br>
    <br>
    提出人：${epicInfo.proposer}

    <h3>用户：</h3>

    经办人：${epicInfo.managers}
    <br>
    <br>
    报告人：${epicInfo.reporter}
    <br>
    <br>
    <h3>日期：</h3>

    创建：${epicInfo.createEpicDate}
    <br>

    更新：${epicInfo.modiEpicDate}
    <br>

    需求收集日期：${epicInfo.demandCollDate}
    <br>

    需求分析开始时间：${epicInfo.demandAnalStartDate}
    <br>

    需求分析结束时间：${epicInfo.demandAnalEndDate}
    <br>
    <br>
    <a onclick="editBtn()" class="btn btn-default">编辑</a>

</div>

<script type="text/javascript">
    function editBtn() {
        window.location.href = "http://localhost:8080/editquestion.jsp"
    }

</script>
</body>
</html>
