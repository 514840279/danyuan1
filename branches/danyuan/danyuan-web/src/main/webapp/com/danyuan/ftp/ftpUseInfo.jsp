<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FTP服务器管理</title>
</head>
<body>
<div data-options="region:'center',border:false" style="width: 100%;">
		<table id="ftpUse_dg_addressInfo" title='FTP地址明细' class="easyui-datagrid">
			<thead frozen="false">
				<tr>
					<th field="ckid" checkbox="true">复选框</th>
					<th data-options="field:'name',width:60" sortable="false"
						align="center" formatter="dgFtpUseInfo_showDetailFormatter">主机名称
					</th>
					<th data-options="field:'householdRegistration',width:80"
						sortable="false" align="center">主机IP</th>
					<th data-options="field:'idcard',width:125" sortable="false"
						align="center">端口号</th>
					<th data-options="field:'telephone',width:100" sortable="false"
						align="left">用户名</th>
					<th data-options="field:'email',width:180" sortable="false"
						align="left">用户密码</th>
					<th data-options="field:'graduationDate',width:100 "
						sortable="false" align="center">操作人</th>
					<th data-options="field:'universityName',width:200"
						sortable="false" align="left">操作时间</th>
					<th data-options="field:'graduationDate',width:100 "
						sortable="false" align="center">修改人</th>
					<th data-options="field:'universityName',width:200"
						sortable="false" align="left">修改时间</th>
				</tr>
			</thead>
		</table>
	</div>
</body>
</html>