<%--
  Created by IntelliJ IDEA.
  User: fisherman
  Date: 2017/11/9
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎页</title>
    <link rel='stylesheet' href='bootstrap/css/bootstrap.min.css'>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <style type="text/css">
        #centr {
            width: 300px;
            height: 200px;
            position: absolute;
            left: 50%;
            top: 20%;
            margin: -100px 0 0 -150px;
        }

    </style>
</head>
<body>
<div id="centr">

<h1>欢迎页面</h1>
<ul class="nav nav-pills">
    <li role="presentation"><a href="http://localhost:8080/createquestion.jsp">创建问题</a></li>
    <li role="presentation" ><a href="http://localhost:8080/questionlist.jsp">需求管理</a></li>
    <li role="presentation"><a href="http://localhost:8080/staff.jsp">人员管理</a></li>
</ul>
</div>
</body>
</html>
