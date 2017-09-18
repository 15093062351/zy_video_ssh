<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Hellow World</title>

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">

<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<style>
.jumbotron {
	margin-left: 150px;
	margin-right: 150px;
	padding-top: 10px;
	padding-bottom: 10px;
}

form {
	display: inline-block;
}
</style>

</head>
<body>


	<nav class="navbar navbar-inverse">
		<div style="margin-left: 150px;">
			<ul class="nav navbar-nav">
				<li><a href="#">视频管理系统</a></li>
				<li><a href="${pageContext.request.contextPath}/Video/videoList">视频管理</a></li>
				<li><a href="#">主讲人管理</a></li>
				<li><a href="#">课程管理</a></li>
				<li><a href="#">统计分析</a></li>

				<li><a href="#">
						<li>admin <span class="glyphicon glyphicon-log-out"
							aria-hidden="true"></span> <span class="glyphicon-class"></span>
					</li>
				</a></li>
			</ul>
		</div>
	</nav>
	<div class="jumbotron">
		<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;添加视频信息--视频管理</h2>
	</div>

	<form class="form-horizontal" action="${pageContext.request.contextPath}/Video/videobaocun" method="post">
		<div class="form-group">
			<label for="inputEmail3" class="col-md-3 control-label">视频标题</label>
			<div class="col-md-8">
				<input type="text" class="form-control"  name="videoTitle"  placeholder="请填写视频标题">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-3 control-label">主讲人</label>
			<div class="col-md-8">
				<!--<input type="password" class="form-control" placeholder="">-->
				<select name="speakerId" style="width: 650px; height: 40px;">
					<option value="">请选择主讲人</option>
					<c:forEach var="list" items="${list}" varStatus="status">
						<option value="${list.id}">${list.speakerName}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-3 control-label">所属课程</label>
			<div class="col-md-8">
				<!--<input type="password" class="form-control" " placeholder=" ">-->
				<select name="courseId" style="width: 650px; height: 40px;">
					<option value="">请选择课程</option>
					<c:forEach var="course" items="${course}" varStatus="status">
						<option value="${course.id}">${course.courseName}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-3 control-label">视频时长</label>
			<div class="col-md-8">
				<input type="password" class="form-control"  name="videoLength"   placeholder="视频时长">
			</div>
		</div>

		<div class="form-group">
			<label class="col-md-3 control-label">封面图片</label>
			<div class="col-md-8">
				<input type="text" class="form-control"    name="videoImageUrl"     placeholder="封面图片地址">
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-3 control-label">视频播放地址</label>
			<div class="col-md-8">
				<input type="text" class="form-control"    name="videoUrl"     placeholder="封面图片地址">
			</div>
		</div>
		<div class="form-group ">
			<label class="col-md-3 control-label ">视频简介</label>
			<div class="col-md-8 ">
				<textarea class="p100 "  name="videoDescr"
					 placeholder="请填写视频描述 " style="width: 1000px; height: 100px;"></textarea>
			</div>
		</div>

		<div class="form-group " style="margin-left: 160px;">
			<input class="btn btn-primary va-bottom " type="submit" value="保存 ">&nbsp;&nbsp;
			<a class="btn btn-default " href="javascript:history.go(-1) ">返回列表</a>
		</div>
	</form>





</body>
</html>