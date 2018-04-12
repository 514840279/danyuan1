<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body system="FTP管理" title="test信息">
<script type="text/javascript" src="src/main/webapp/jslib/jquery-easyui-1.4/plugins/ajaxfileupload.js"></script>
<input type="hidden" id="hideEmployeeID"/>

<form id="ftp_test">
<table>
<tr>
	<td>
		<input id="fb" type="text" style="width:300px" name="fileter">
	</td>
	
	<td>
		<input >
	</td>
	
	<td>
		<input type="button" value="   提交     " onclick="go()">
	</td>
	
</tr>
</table>

</form>
<script type="text/javascript" src="FTPtest.js"></script>
</body>
</html>