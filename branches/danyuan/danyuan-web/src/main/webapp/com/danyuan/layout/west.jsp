<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="easyui-accordion" data-options="fit:true">
		<div title="系统菜单" data-options="iconCls:'icon-save'">
			<ul id="layout_west_tree" class="easyui-tree" data-options="
					url : '${pageContext.request.contextPath}/menuAction!getAllTreeNode.action',
					parentField : 'pid', 
					lines : true, 
 					onClick : function(node) {
 						if (node.attributes.url) {
 							var url = '${pageContext.request.contextPath}' + node.attributes.url; 
 							addTab({ 
 								title : node.text, 
 								closable : true, 
 								href : url 
 							});
 						}
 					} 
 					"></ul> 
		</div>
		<div title="Title2" data-options="iconCls:'icon-reload'"></div>
        <%--遍历菜单--%>
		<c:forEach items="layout_west_tree">
			<div title="Title2" data-options="iconCls:'icon-reload'"></div>
		
		</c:forEach>
	</div>
