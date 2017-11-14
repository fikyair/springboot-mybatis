<%--
  Created by IntelliJ IDEA.
  User: fisherman
  Date: 2017/6/22
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());//以服务器的路径为标准，http://localhost:3306
    %>
    <link rel='stylesheet' href='bootstrap/css/bootstrap.min.css'>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script src="${APP_PATH}/js/jquery-3.2.1.js"></script>

    <style type="text/css">
        .form-bg {
            background: #00b4ef;
        }

        .form-horizontal {
            background: #fff;
            padding-bottom: 40px;
            border-radius: 15px;
            text-align: center;
        }

        .form-horizontal .heading {
            display: block;
            font-size: 35px;
            font-weight: 700;
            padding: 35px 0;
            border-bottom: 1px solid #f0f0f0;
            margin-bottom: 30px;
        }

        .form-horizontal .form-group {
            padding: 0 40px;
            margin: 0 0 25px 0;
            position: relative;
        }

        .form-horizontal .form-control {
            background: #f0f0f0;
            border: none;
            border-radius: 20px;
            box-shadow: none;
            padding: 0 20px 0 45px;
            height: 40px;
            transition: all 0.3s ease 0s;
        }

        .form-horizontal .form-control:focus {
            background: #e0e0e0;
            box-shadow: none;
            outline: 0 none;
        }

        .form-horizontal .form-group i {
            position: absolute;
            top: 12px;
            left: 60px;
            font-size: 17px;
            color: #c8c8c8;
            transition: all 0.5s ease 0s;
        }

        .form-horizontal .form-control:focus + i {
            color: #00b4ef;
        }

        .form-horizontal .fa-question-circle {
            display: inline-block;
            position: absolute;
            top: 12px;
            right: 60px;
            font-size: 20px;
            color: #808080;
            transition: all 0.5s ease 0s;
        }

        .form-horizontal .fa-question-circle:hover {
            color: #000;
        }

        .form-horizontal .main-checkbox {
            float: left;
            width: 20px;
            height: 20px;
            background: #11a3fc;
            border-radius: 50%;
            position: relative;
            margin: 5px 0 0 5px;
            border: 1px solid #11a3fc;
        }

        .form-horizontal .main-checkbox label {
            width: 20px;
            height: 20px;
            position: absolute;
            top: 0;
            left: 0;
            cursor: pointer;
        }

        .form-horizontal .main-checkbox label:after {
            content: "";
            width: 10px;
            height: 5px;
            position: absolute;
            top: 5px;
            left: 4px;
            border: 3px solid #fff;
            border-top: none;
            border-right: none;
            background: transparent;
            opacity: 0;
            -webkit-transform: rotate(-45deg);
            transform: rotate(-45deg);
        }

        .form-horizontal .main-checkbox input[type=checkbox] {
            visibility: hidden;
        }

        .form-horizontal .main-checkbox input[type=checkbox]:checked + label:after {
            opacity: 1;
        }

        .form-horizontal .text {
            float: left;
            margin-left: 7px;
            line-height: 20px;
            padding-top: 5px;
            text-transform: capitalize;
        }

        .form-horizontal .btn {
            float: right;
            font-size: 14px;
            color: #fff;
            background: #00b4ef;
            border-radius: 30px;
            padding: 10px 25px;
            border: none;
            text-transform: capitalize;
            transition: all 0.5s ease 0s;
        }

        @media only screen and (max-width: 479px) {
            .form-horizontal .form-group {
                padding: 0 25px;
            }

            .form-horizontal .form-group i {
                left: 45px;
            }

            .form-horizontal .btn {
                padding: 10px 20px;
            }
        }

    </style>


</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <form class="form-horizontal">
                <span class="heading">用户登录</span>
                <div class="form-group">
                    <input type="email" class="form-control" id="username" name="username" placeholder="用户名">
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group help">
                    <input type="password" class="form-control" id="password" name="password" placeholder="密　码">
                    <i class="fa fa-lock"></i>
                    <a href="#" class="fa fa-question-circle"></a>
                </div>
                <div class="form-group">
                    <a onclick="MiMa()" class="btn btn-default">忘记密码</a>&nbsp;&nbsp;&nbsp;&nbsp;
                    <a onclick="submit()" class="btn btn-default">登录</a>&nbsp;&nbsp;&nbsp;&nbsp;
                </div>
            </form>
        </div>
    </div>
</div>


<script>


    function submit() {
        var uname = $("#username").val();//获取文本框的信息
        var password = $("#password").val();//获取文本框的信息
        $.ajax({
            url: "http://localhost:8080/login/logincheck/" + uname + "/" + password,
            method: "post",
            data: {
                "uname": uname,  //做好向 后台发数据的准备，后台直接可以取到
                "password": password
            },
            success: function (data) {//这里是形参，后台返回data数据

                alert(data);
                window.location.href = 'http://localhost:8080/index.jsp';
            },
            error: function () {
                alert("失败");
            }
        })
    }
    function MiMa() {
        var uname = $("#username").val();//获取文本框的信息
        var password = $("#password").val();//获取文本框的信息
        $.ajax({
            url: "http://localhost:8080/login/logincheck/" + uname + "/" + password,
            method: "post",
            data: {
                "uname": uname,  //做好向 后台发数据的准备，后台直接可以取到
                "password": password
            },
            success: function (data) {//这里是形参，后台返回data数据

                alert(data);
                window.location.href = 'http://localhost:8080/index.jsp';
            },
            error: function () {
                alert("失败");
            }
        })
    }

</script>
</body>
</html>
