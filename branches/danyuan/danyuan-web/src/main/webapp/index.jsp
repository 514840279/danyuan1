<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML >
<html>
<head>
<title>DANYUAN</title>
<meta charset="UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="jslib/jquery-easyui-1.4/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="jslib/jquery-easyui-1.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jslib/jquery-easyui-1.4/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="jslib/core.js"></script>
<link rel="stylesheet" href="jslib/jquery-easyui-1.4/themes/default/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="jslib/jquery-easyui-1.4/themes/icon.css" type="text/css"></link>
<script type="text/javascript" src="jslib/syUtil.js"></script>

</head>
<body class="easyui-layout">
	<div data-options="region:'north'" style="height:60px;"></div>
	<div data-options="region:'south'" style="height:20px;"></div>
	<div data-options="region:'west',title:'首页',split:true" style="width:200px;">
		<jsp:include page="com/danyuan/layout/west.jsp"></jsp:include>
	</div>
	<div data-options="region:'east',title:'east',split:true" style="width:200px;"></div>
	<div data-options="region:'center',title:'欢迎使用单源系统'" style="overflow: hidden;">
		<jsp:include page="com/danyuan/layout/center.jsp"></jsp:include>
	</div>

	<jsp:include page="com/danyuan/user/login.jsp"></jsp:include>

	<jsp:include page="com/danyuan/user/reg.jsp"></jsp:include>
</body>
</html>
