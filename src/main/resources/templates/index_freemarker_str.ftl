<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>Freemarker</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewpoint" content="width=device-width,initial-scale=1.0">
    <!-- 引入bootstrap样式 -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet" media="screen">
    <!--<link href="WEB-INF/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet" media="screen">-->

    <!-- 引入bootstrap-table样式 -->
    <link href="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.css" rel="stylesheet">
</head>
<body>

<h1>Hello World!</h1>
<span>${name}</span>

<#--
<span>
    <#list map ? keys as key>
        ${key}:${map[key]}
    </#list>
</span>
-->

<!-- jquery -->
<!--<script src="WEB-INF/bootstrap-3.3.7-dist/js/jquery-3.3.1.js"></script>-->
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
<!--<script src="WEB-INF/bootstrap-3.3.7-dist/js/bootstrap.js"></script>-->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>
<!-- bootstrap-table.min.js -->
<script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>
<!-- 引入中文语言包 -->
<script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>
</body>
</html>