<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<style>
.body {
	background-color: #fff;
	display: flex;
	justify-content: center;
	align-items: center;
}
</style>

</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid" style="width: 60%;">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-9"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">视频管理系统</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-9">
				<ul class="nav navbar-nav">
					<li><a
						href="${pageContext.request.contextPath }/admin/recose/recoseList.action">视频管理</a></li>
					<li><a
						href="${pageContext.request.contextPath }/admin/speaker/speakerList.action">主讲人管理</a></li>
					<li class="active"><a href="#">课程管理</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<div class="jumbotron" align="middle">
		<h2>添加课程</h2>
	</div>
	<div class="body">
		<div style="width: 60%;">
			<form class="form-horizontal"
				action="${pageContext.request.contextPath }/Course/addcoursebaocun"
				method="post">

				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">所属学科</label>
					<div class="col-sm-10">
						<%-- <select class="form-control" name="subjectId">
					           <c:forEach items="${list}" var="mm">
		 							  <option value="${mm.id }" ${subjectId eq mm.id ? "selected":""}>${mm.subjectName }</option>
								</c:forEach>	 
						</select>  --%>
						<select name="subjectId" style="width: 650px; height: 40px;">
							<option value="">请选择所属学科</option>
							<c:forEach var="list" items="${list}" varStatus="status">
								<option value="${list.id}">${list.subjectName}</option>
							</c:forEach> 
						</select>

					</div>
				</div>

				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">标题</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputPassword3"
							placeholder="课程标题" name="courseName">
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">简介</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail3"
							placeholder="课程简介" name="courseDescr">
					</div>
				</div>
				<input type="hidden" name="id" value="${li.id }">
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary va-bottom">保存</button>

					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>