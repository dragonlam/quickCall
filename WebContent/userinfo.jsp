<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>套餐推荐查询</title>
	<%
	// 权限验证
	if(session.getAttribute("currentStaff")==null){
		response.sendRedirect("index.jsp");
		return;
	}
	%>
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.3/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.3/themes/icon.css">
	<script type="text/javascript" src="jquery-easyui-1.3.3/jquery.min.js"></script>
	<script type="text/javascript" src="jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
	<script>
		var url;
		
		function exportUser2(){
			window.open('user!export2');
		}
		
		function downloadTemplate(){
			window.open('template/userExporTemplate.xls');
		}
		
		function uploadFile(){
			var uploadFile = $("#uploadFile").val();
		    if(uploadFile=='') {
		    	alert("请选择需上传的文件!");
		    	return false;
		    }else if(uploadFile.indexOf('.xls')==-1){
		    	alert("文件格式不正确，请选择正确的Excel文件(后缀名.xls)！");
		    	return false;
		    }
			$("#uploadForm").form("submit",{
				success:function(result){
					var result=eval('('+result+')');
					if(result.errorMsg){
						$.messager.alert("系统提示",result.errorMsg);
					}else{
						$.messager.alert("系统提示","上传成功");	
					}
				}
			});
		}
		
	</script>
</head>
<body>
	<table id="dg" title="用户管理" class="easyui-datagrid" 
            url="user!list"
            toolbar="#toolbar" pagination="true"
            rownumbers="true" fitColumns="true" singleSelect="true">
        <thead>
            <tr>
            	<th field="id" width="50" hidden="true">编号</th>
                <th field="name" width="15">用户姓名</th>
                <th field="phone" width="20">电话号码</th>
                <th field="email" width="50">推荐套餐</th>
                <th field="qq" width="30">备注</th>
            </tr>
        </thead>
    </table>
    <div id="toolbar">
	    <table>
		    <tr>		    
				<td><form id="uploadForm" action="user!upload" method="post" enctype="multipart/form-data">					
					<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-import" plain="true" onclick="uploadFile()">上传excel文件</a>
					<input type="file" id="uploadFile" name="userUploadFile">
				</form></td>
		        <td><a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-export" plain="true" onclick="exportUser2()">导出excel文件</a></td>
		        <td><a href="javascript:void(0)" class="easyui-linkbutton"  iconCls="icon-import" plain="true" onclick="downloadTemplate()">下载excel模版</a></td>
		    </tr>
	    </table>             
    </div>
	      
</body>
</html>
