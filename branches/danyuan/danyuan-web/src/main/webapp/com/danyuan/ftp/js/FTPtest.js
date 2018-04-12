$(function(){
	$('#fb').filebox({    
	    buttonText: '选择文件', 
	    buttonAlign: 'left' 
	})
	
});
function go(){
	alert(11);
	$.ajax({
        cache: true,
        type: "POST",
        url:"ftpUseAction!upload.action",
        fileElementId:"fd",// 你的formid
        async: false,
        error: function(request) {
            alert("Connection error");
        },
        success: function(data) {
        	alert(1);
        }
    });
}