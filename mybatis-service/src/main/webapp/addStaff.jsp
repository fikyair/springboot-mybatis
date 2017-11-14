<%--
  Created by IntelliJ IDEA.
  User: fisherman
  Date: 2017/11/9
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加人员</title>
    <style type="text/css">
        #centr {
            width: 700px;
            height: 200px;
            position: absolute;
            left: 50%;
            top: 20%;
            margin: -100px 0 0 -150px;
        }

    </style>
    <link rel='stylesheet' href='bootstrap/css/bootstrap.min.css'>
    <link rel='stylesheet' href='bootstrap/css/bootstrap-datetimepicker.css'>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-datetimepicker.js"></script>
</head>
<body>
<div id="centr">
    <h1>添加人员</h1>
    <form id="formId" action="staff/add" method="post">
        <table class="table table-hover">
            <tr>
                <td>员工编号</td>
                <td><input id="staffId" type="text" class="form-control" name="staffId"></td>
                <td>姓名</td>
                <td><input id="staffName" type="text" class="form-control" name="staffName"></td>
            </tr>
            <tr>
                <td>性别</td>
                <td><input id="sex" type="text" class="form-control" name="sex"></td>
                <td>中文全拼</td>
                <td><input id="chineseName" type="text" class="form-control" name="chineseName"></td>
            </tr>
            <tr>
                <td>基础角色</td>
                <td><input id="basicRole" type="text" class="form-control" name="basicRole"></td>
                <td>出生日期</td>
                <td>
                    <div class="input-append date form_datetime">
                        <input size="16" type="text" id="birthday" name="birthday">
                        <span class="add-on"><i class="icon-th"></i></span>
                    </div>
                </td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td><input id="email" type="text" class="form-control" name="email"></td>
                <td>手机</td>
                <td><input id="phone" type="text" class="form-control" name="phone"></td>
            </tr>
            <tr>
                <td>状态</td>
                <td><input id="status" type="text" class="form-control" name="status"></td>
                <td>入职时间</td>
                <td>
                    <div class="input-append date form_datetime">
                        <input size="16" type="text" id="hiredDate" name="hiredDate">
                        <span class="add-on"><i class="icon-th"></i></span>
                    </div>
                </td>
            </tr>
        </table>
        <%--   <input  class="btn btn-default" type="submit" value="提交">--%>
        <a onclick="formSubmit()" class="btn btn-default">提交</a>&nbsp;&nbsp;&nbsp;&nbsp;
        <input class="btn btn-default" type="reset" value="取消">
    </form>
</div>
<script type="text/javascript">
    $(".form_datetime").datetimepicker({
        autoclose: true,
        todayBtn: true,
        format: "yyyy-mm-dd",
        startDate: "2013-02-14 10:00",
        minuteStep: 10
    });

    function formSubmit() {
        $.ajax({
            type: 'POST',
            dataType: 'text',
            url: "http://localhost:8080/staff/add",
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
