<%--
  Created by IntelliJ IDEA.
  User: fisherman
  Date: 2017/11/9
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--<div style="display:none">
    <jsp:include page="stafflist.jsp" flush="true"/>
</div>--%>
<head>
    <title>欢迎页</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());//以服务器的路径为标准，http://localhost:3306
    %>
    <link rel='stylesheet' href='bootstrap/css/bootstrap.min.css'>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <style type="text/css">

        #centr {
            height: 200px;
            position: absolute;
            left: 15%;
            top: 20%;
            margin: -100px 0 0 -150px;
        }

    </style>
</head>
<body>

<div id="centr">
    <h1>人员管理</h1>
    <a onclick="queryBtn()" class="btn btn-default">查询</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a class="btn btn-default" href="http://localhost:8080/addStaff.jsp" role="button">添加</a>
    <br>
    <br>
    <form id="formId">
        <table class="table table-hover">
            <tr>
                <td> 登录Id：</td>
                <td><input id="userName" type="text" name="userName" class="form-control"></td>
                <td>员工编号：</td>
                <td><input id="staffId" type="text" name="staffId" class="form-control"></td>
            </tr>
            <tr>
                <td> 姓名：</td>
                <td><input id="staffName" type="text" name="staffName" class="form-control"></td>
                <td> 基础角色：</td>
                <td>
                    <select class="form-control" id="baseRole" name="baseRole">
                        <option></option>
                        <option>全部</option>
                        <option>产品需求</option>
                        <option>开发测试</option>
                    </select>
                </td>
            </tr>
        </table>
    </form>

    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1>人员管理列表</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <table class="table table-hover" id="staff_table">
                    <thead>
                    <tr><%-- 10--%>
                        <th>登录ID</th>
                        <th>员工编号</th>
                        <th>姓名</th>
                        <th>中文全拼</th>
                        <th>基础角色</th>
                        <th>状态</th>
                        <th>创建时间</th>
                        <th>修改时间</th>
                        <th>操作员</th>
                        <th>管理</th>
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
    var totalRecord, currentPage;
    function queryBtn() {
        $.ajax({
            url: "${APP_PATH}/staff/dynquery" + "/" + 1,
            type: 'POST',
            data: $("#formId").serializeArray(),
            contentType: "application/x-www-form-urlencoded",
            success: function (result) {
                console.log(result);
                //1、解析并显示员工数据
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
            var user_nameTd = $("<td></td>").append(item.user_name);
            var staffIdTd = $("<td></td>").append(item.staffId);
            var staffNameTd = $("<td></td>").append(item.staffName);
            var chineseNameId = $("<td></td>").append(item.chineseName);
            var basicRoleTd = $("<td></td>").append(item.basicRole);
            var statusTd = $("<td></td>").append(item.status);
            var createDateTd = $("<td></td>").append(item.createDate);
            var modiDateTd = $("<td></td>").append(item.modiDate);
            var operatorTd = $("<td></td>").append(item.operator);

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
                .append(user_nameTd)
                .append(staffIdTd)
                .append(staffNameTd)
                .append(chineseNameId)
                .append(basicRoleTd)
                .append(statusTd)
                .append(createDateTd)
                .append(modiDateTd)
                .append(operatorTd)
                .append(btnTd)
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


</script>

</body>
</html>

