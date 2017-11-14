<%--
  Created by IntelliJ IDEA.
  User: fisherman
  Date: 2017/11/9
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>需求管理</title>
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
    <link rel='stylesheet' href='bootstrap/css/bootstrap.min.css'>
    <link rel='stylesheet' href='bootstrap/css/bootstrap-datetimepicker.css'>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-datetimepicker.js"></script>

</head>
<body>

<div id="centr">
    <h1>需求管理</h1>
    <form id="formId">

        <a onclick="queryBtn()" class="btn btn-default">查询</a>
        <input class="btn btn-default" type="reset" value="重置">
        <br><br>

        <table class="table table-hover">
            <tr>
                <td> 史诗编号</td>
                <td><input id="epicID" name="epicId" type="text" class="form-control"></td>
                <td>提出人</td>
                <td><input id="proposer" name="proposer" type="text" class="form-control"></td>
                <td>主题</td>
                <td><input id="topic" name="topic" type="text" class="form-control"></td>
                <td>收集日期</td>
                <td>
                    <div class="input-append date form_datetime">
                        <input size="16" type="text" id="demanCollDateStart" name="demanCollDateStart">
                        <span class="add-on"><i class="icon-th"></i></span>
                    </div>
                </td>
                <td>
                    至
                </td>
                <td>
                    <div class="input-append date form_datetime">
                        <input size="16" type="text" id="demanCollDateend" name="demanCollDateend">
                        <span class="add-on"><i class="icon-th"></i></span>
                    </div>
                </td>
            </tr>
            <tr>
                <td>分析完成时间：</td>
                <td>
                    <div class="input-append date form_datetime">
                        <input size="16" type="text" id="demanAnalStartDate" name="demanAnalStartDate">
                        <span class="add-on"><i class="icon-th"></i></span>
                    </div>

                </td>
                <td>
                    至
                </td>
                <td>
                    <div class="input-append date form_datetime">
                        <input size="16" type="text" id="demanAnalEndDate" name="demanAnalEndDate">
                        <span class="add-on"><i class="icon-th"></i></span>
                    </div>
                </td>
                <td>状态</td>
                <td>
                    <select class="form-control" id="status" name="status">
                        <option></option>
                        <option>紧急</option>
                        <option>严重</option>
                        <option>重要</option>
                        <option>次要</option>
                        <option>微小</option>
                    </select>
                </td>
                <td></td>
                <td></td>
            </tr>
        </table>
    </form>

    <div class="container">
        <div class="row">
            <div class="col-md-12">

            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <table class="table table-hover" id="staff_table">
                    <thead>
                    <tr><%-- 10--%>
                        <th>业务部门</th>
                        <th>提出人</th>
                        <th>史诗编号</th>
                        <th>项目名称</th>
                        <th>问题类型</th>
                        <th>主题</th>
                        <th>状态</th>
                        <th>受理日期</th>
                        <th>分析开始时间</th>
                        <th>分析完成时间</th>
                    </tr>
                    </thead>
                    <tbody>

                    </tbody>

                </table>
            </div>

        </div>
        <div class="row">
            <%-- 分页信息--%>
            <div class="col-md-6" id="page_info_area">

            </div>
            <div class="col-md-6">
                <nav aria-label="Page navigation">
                    <ul class="pagination" id="page_nav_area">
                        <li>
                            <a href="#"> 首页</a>

                        </li>
                        <li>
                            <a href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li>
                            <a href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                        <li>
                            <a href="#"> 末页</a>

                        </li>
                    </ul>
                </nav>

            </div>

        </div>
        <%-- <a onclick="test()"> test</a>--%>
    </div>
</div>
<script type="text/javascript">
    $(".form_datetime").datetimepicker({
        autoclose: true,
        todayBtn: true,
        format: "yyyy/mm/dd",
        startDate: "2013/02/14",
        minuteStep: 10
    });

    var totalRecord, currentPage;
    function queryBtn() {
        $.ajax({
            url: "${APP_PATH}/epic/epicQuery" + "/" + 1,
            type: 'POST',
            data: $("#formId").serializeArray(),
            contentType: "application/x-www-form-urlencoded",
            success: function (result) {
                console.log(result);
                //1、解析并显示史诗数据
                build_staff_table(result);
                //2、解析并显示分页数据
                build_page_info(result);
                //3、显示分页条
                build_page_nav(result);
            }

        })

    }
    function build_staff_table(result) {
        //清空之前的数据
        $("#staff_table tbody").empty();
        var staff = result.extend.pageInfo.list;
        $.each(staff, function (index, item) {
            // 回调函数，第一个参数代表索引  第二个参数代表 是 list里面的数据（每循环一次是一条）

            var createEpicDateTd = $("<td></td>").append(item.createEpicDate);
            var demandAnalEndDateTd = $("<td></td>").append(item.demandAnalEndDate);
            var demandAnalStartDateTd = $("<td></td>").append(item.demandAnalStartDate);
            var epicIdTd = $("<td></td>").append($("<a id='epicInfo' onclick='epicInfo(" + item.epicId + ")'></a>").append(item.epicId));
            var operationDeptTd = $("<td></td>").append(item.operationDept);
            var projectNameTd = $("<td></td>").append(item.projectName);
            var proposerTd = $("<td></td>").append(item.proposer);
            var questionTypeTd = $("<td></td>").append(item.questionType);
            var statusTd = $("<td></td>").append(item.status);
            var topicTd = $("<td></td>").append(item.topic);

            var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("查看");
            //为查看按钮添加一个自定义属性，来表示当前员工id
            editBtn.attr("edit-id", item.empId);
            var modiBtn = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("修改");

            modiBtn.attr("del-id", item.empId);
            var btnTd = $("<td></td>").append(editBtn).append(" ").append(modiBtn);

            //append方法执行完成后还是返回原来的元素
            $("<tr></tr>")
                .append(operationDeptTd)
                .append(proposerTd)
                .append(epicIdTd)
                .append(projectNameTd)
                .append(questionTypeTd)
                .append(topicTd)
                .append(statusTd)
                .append(createEpicDateTd)
                .append(demandAnalStartDateTd)
                .append(demandAnalEndDateTd)
                .appendTo("#staff_table tbody");
        })
    }
    //显示分页信息
    function build_page_info(result) {

        //清空
        $("#page_info_area").empty();

        $("#page_info_area").append("当前" + result.extend.pageInfo.pageNum + "页，总共有" + result.extend.pageInfo.pages + " 页，总共有" + result.extend.pageInfo.total + " 条记录");
        totalRecord = result.extend.pageInfo.total;
        currentPage = result.extend.pageInfo.pageNum;
    }
    //显示分页条
    function build_page_nav(result) {
        //清空
        $("#page_nav_area").empty();
        var nav = $("<nav></nav>").addClass("Page navigation");
        var ul = $("<ul></ul>").addClass("pagination");
        var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));

        var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));

        if (result.extend.pageInfo.hasPreviousPage == false) {
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        } else {
            firstPageLi.click(function () {
                to_page(1);
            })
            prePageLi.click(function () {
                to_page(result.extend.pageInfo.pageNum - 1);
            })
        }
        var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));

        var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href", "#"));

        if (result.extend.pageInfo.hasNextPage == false) {
            nextPageLi.addClass("disabled");
            lastPageLi.addClass("disabled");
        } else {
            lastPageLi.click(function () {
                to_page(result.extend.pageInfo.pages);
            })
            nextPageLi.click(function () {
                to_page(result.extend.pageInfo.pageNum + 1);
            })
        }
        //页码号  "navigatepageNums":[1,2,3,4,5]
        ul.append(firstPageLi).append(prePageLi);
        $.each(result.extend.pageInfo.navigatepageNums, function (index, item) {
            var numLi = $("<li></li>").append($("<a></a>").append(item));
            if (result.extend.pageInfo.pageNum == item) {
                numLi.addClass("active");
            }
            numLi.click(function () {
                to_page(item);
            })
            ul.append(numLi);
        })

        ul.append(nextPageLi).append(lastPageLi);

        nav.append(ul);
        nav.appendTo("#page_nav_area");
    }
    //单击导航条 跳转到指定页码
    function to_page(pn) {
        $.ajax({
            url: "${APP_PATH}/staff/dynquery" + "/" + pn,
            type: "GET",
            success: function (result) {
                //console.log(result);
                //1、解析并显示员工数据
                build_staff_table(result);
                //2、解析并显示分页数据
                build_page_info(result);
                //3、显示分页条
                build_page_nav(result);
            }

        })
    }
    //跳转到史诗详情页面

    function epicInfo(epicIdTd) {
        // alert($('#epicInfo').html());
        $.ajax({
            url: "${APP_PATH}/epic/findOneEpic" + "/" + epicIdTd,//将epicId当参数
            type: "GET",
            success: function (result) {
                window.location.href = "http://localhost:8080/epicInfo.jsp"
            },
            error: function () {
                alert("fail")
            }

        })

    }

</script>
</body>
</html>
