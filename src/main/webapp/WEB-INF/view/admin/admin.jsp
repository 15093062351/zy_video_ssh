<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>	
	
	
	
<!DOCTYPE html>
<html>

<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="css/bootstrap.min.css" rel="stylesheet">

<script src="js/jquery-1.12.4.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<script type="text/javascript" src="ss/JQuery/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="ss/JQuery/jquery.validate.min.js"></script>
<script type="text/javascript" src="ss/JQuery/messages_zh.min.js"></script>

<script type="text/javascript">

$(function(){
	
	$("#checkForm").validate({
		rules:{
			loginName:{
				required:true,
				minlength:3
			},
			loginPwd:{
				required:true
			},
			loginRPwd:{
				required:true,
				equalTo:"input[name=loginPwd]"
			}
		},
		messages:{
			loginName:{
				required:"用户名不能为空",
				minlength:"长度太小"
			},
			loginPwd:{
				required:"输入密码"
			},
			loginRPwd:{
				required:"请确认密码",
				equalTo:"用户名密码必须一致"
			}
		}
	});
});


</script>


</head>
<body>
	<div align="center"
		style="margin: 0 auto; width: 250px; margin-top: 300px;">
		<div>
			<img src="${pageContext.request.contextPath}/img/logo.png"
				class="img-responsive " alt="Responsive image">
		</div>
		<form action="admin/adminUser" method="post" id="checkForm">
			<div class="form-group">
				<input type="text"  name="loginName" value="admin"   class="form-control" placeholder="请输入用户名">
			</div>
			<div class="form-group">
				<input type="password" name="loginPwd"  value="123"   class="form-control" placeholder="请输入密码">
			</div>
			<div class="form-group">
				<input type="password" name="loginRPwd"  value="123"   class="form-control" placeholder="请确认密码">
			</div>
		    <p style="color: red; font-size: 15px;">${message }</p>
			<button type="submit" class="form-control btn btn-success"
				style="height: 30px;">登录</button>
		</form>
	</div>
</body>

</html>