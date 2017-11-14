<%--
  Created by IntelliJ IDEA.
  User: fisherman
  Date: 2017/11/9
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel='stylesheet' href='bootstrap/css/bootstrap.min.css'>
    <link rel='stylesheet' href='bootstrap/css/bootstrap-datetimepicker.css'>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-datetimepicker.js"></script>
    <style type="text/css">
        #centr {
            width: 300px;
            height: 200px;
            position: absolute;
            left: 50%;
            top: 20%;
            margin: -100px 0 0 -150px;
        }

        #line {
            width: 80%;
            height: 1px;
            margin-top: 10px;
            background-color: #D5D5D5;
            overflow: hidden;
        }

        #distance {
            margin-top: 15px;

        }
    </style>

</head>
<body>


<div id="centr">
    <h1> 创建问题 </h1>
    <form id="formId" class="navbar-form navbar-left" role="search" method="post" action="epic/add">
        <div class="form-group">

            项&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;目：
            <select class="form-control" id="projectName" name="projectName">
                <option>需求受理</option>
            </select>

            <br><br>
            问题类型 ：
            <select class="form-control" id="questionType" name="questionType">
                <option>业务问题</option>
            </select>
        </div>
        <div id="line"></div>
        <br><br>
        <div id="distance">
            Epic&nbsp;&nbsp;&nbsp; Name ：<input id="epicName" name="epicName" type="text" class="form-control"><br><br>
            主&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题：<input id="topic" name="topic" type="text"
                                                                      class="form-control"><br><br>
            业务部门 ：<input name="operationDept" id="operationDept" type="text" class="form-control"><br><br>
            提&nbsp;&nbsp;出&nbsp;&nbsp;人 ：<input id="proposer" name="proposer" type="text" class="form-control"><br><br>
            优&nbsp;&nbsp;先&nbsp;&nbsp;级 ：
            <select class="form-control" id="priority" name="priority">
                <option>紧急</option>
                <option>严重</option>
                <option>重要</option>
                <option>次要</option>
                <option>微小</option>
            </select><br><br>
            需求收集日期 ：
            <div class="input-append date form_datetime">
                <input size="16" type="text" id="demandCollDate" name="demandCollDate">
                <span class="add-on"><i class="icon-th"></i></span>
            </div>
            <br><br>
            需求分析开始日期 ：
            <div class="input-append date form_datetime">
                <input size="16" type="text" id="demandAnalStartDate" name="demandAnalStartDate">
                <span class="add-on"><i class="icon-th"></i></span>
            </div>
            <br><br>
            需求分析结束日期 ：
            <div class="input-append date form_datetime" name="demandAnalEndDate">
                <input size="16" type="text" id="de_anal_end_date">
                <span class="add-on"><i class="icon-th"></i></span>
            </div>
            <br><br>
            经办人 ：
            <select class="form-control" id="manager" name="managers">
                <option>老赵</option>
                <option>老王</option>
                <option>老李</option>
            </select><br><br>
            描述：<textarea id="descript" name="descript" class="form-control" rows="5"></textarea>

        </div>
        <a onclick="QformSubmit()" class="btn btn-default">提交</a>&nbsp;&nbsp;&nbsp;&nbsp;
    </form>


</div>


<script type="text/javascript">
    $(".form_datetime").datetimepicker({
        autoclose: true,
        todayBtn: true,
        format: "yyyy-mm-dd",
        startDate: "2013-02-14",
        minuteStep: 10
    });

    function QformSubmit() {
        $.ajax({
            type: 'POST',
            dataType: 'text',
            url: "http://localhost:8080/epic/add",
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
