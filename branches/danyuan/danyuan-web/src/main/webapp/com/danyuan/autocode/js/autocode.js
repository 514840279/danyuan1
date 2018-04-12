/**
 * 
 */
$(function(){
	 $('#database').tree({
         checkbox:true,
         url:'autocode.jsp',
         onLoadSuccess:function(){
             //绑定权限
              $.ajax({
                 url:"${pageContext.request.contextPath}/mySQLAction!getMySQLModel.action",
                  cache:false,
                  dataType:'text',
                  success:function(data){  
                     var array = data.split(',');
                     for(var i=0;i<array.length;i++)
                     {
                         var node = $('#treeul').tree('find',array[i]);
                        $('#treeul').tree('check',node.target);
                     }
                 }
             })
         }
     });
});