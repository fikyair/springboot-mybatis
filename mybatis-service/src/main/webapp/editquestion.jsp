<%--
  Created by IntelliJ IDEA.
  User: fisherman
  Date: 2017/11/11
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>史诗（问题）编辑</title>
    <style type="text/css">
        #centr {
            width: 200px;
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
    <from id="formId" action="epic/update" method="post">
        <h3>问题详情：</h3>

        Epic Name：<input type="text" name="questionType" class="form-control" value="${epicInfo.questionType}">

        <br>
        <br>

        主题：<input type="text" name="topic" class="form-control" value="${epicInfo.topic}">
        <br>
        <br>
        业务部门：<input type="text" name="operationDept" class="form-control" value="${epicInfo.operationDept}">
        <br>
        <br>
        提出人：<input type="text" name="proposer" class="form-control" value="${epicInfo.proposer}">
        <br>
        <br>
        问题类型：${epicInfo.questionType}
        <br>
        <br>
        优先级： <select class="form-control" id="priority" name="priority">
        <option selected="selected">${epicInfo.priority}</option>
        <option>紧急</option>
        <option>严重</option>
        <option>重要</option>
        <option>次要</option>
        <option>微小</option>
    </select>
        <br>
        <br>


        需求收集日期 ：
        <div class="input-append date form_datetime">
            <input size="16" type="text" id="demandCollDate" name="demandCollDate" value="${epicInfo.demandCollDate}">
            <span class="add-on"><i class="icon-th"></i></span>
        </div>
        <br><br>
        需求分析开始日期 ：
        <div class="input-append date form_datetime">
            <input size="16" type="text" id="demandAnalStartDate" name="demandAnalStartDate"
                   value="${epicInfo.demandAnalStartDate}">
            <span class="add-on"><i class="icon-th"></i></span>
        </div>
        <br><br>
        需求分析结束日期 ：
        <div class="input-append date form_datetime" name="demandAnalEndDate">
            <input size="16" type="text" id="de_anal_end_date" value="${epicInfo.demandAnalEndDate}">
            <span class="add-on"><i class="icon-th"></i></span>
        </div>
        <br><br>
        经办人 ：
        <select class="form-control" id="manager" name="managers">
            <option>${epicInfo.managers}</option>
            <option>老赵</option>
            <option>老王</option>
            <option>老李</option>
        </select><br><br>
        描述：<textarea id="descript" name="descript" class="form-control" rows="5">
        ${epicInfo.descript}
    </textarea>
        <br>
        <br>
        <a onclick="update()" class="btn btn-default">更新</a>
        <a href="epicInfo.jsp" class="btn btn-default">取消</a>
    </from>

</div>

<script type="text/javascript">
    $(".form_datetime").datetimepicker({
        autoclose: true,
        todayBtn: true,
        format: "yyyy-mm-dd",
        startDate: "2013-02-14",
        minuteStep: 10
    });

    function update() {
        $.ajax({
            url: "http://localhost:8080/epic/update",
            type: 'POST',
            dataType: 'text',
            data: $("#formId").serializeArray(),
            contentType: "application/x-www-form-urlencoded",
            success: function (data) {
                alert("成功！")
            },
            error: function () {
                alert("失败！")
            }

        })
    }

</script>
</body>
</html>
