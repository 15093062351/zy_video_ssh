<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="ll" uri="http://zhiyou100.com/common/"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Hellow World</title>

<link href="${pageContext.request.contextPath}/ss/css/bootstrap.min.css" rel="stylesheet">

<script src="${pageContext.request.contextPath}/ss/js/jquery-1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath}/ss/js/bootstrap.min.js"></script>
<style>
.jumbotron {
	margin-left: 150px;
	margin-right: 150px;
	padding-top: 10px;
	padding-bottom: 10px;
}
</style>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div style="margin-left: 150px;">
			<ul class="nav navbar-nav">
				<li><a href="#">视频管理系统</a></li>
				<li><a href="${pageContext.request.contextPath}/Video/videoList">视频管理</a></li>
				<li><a href="${pageContext.request.contextPath}/Speaker/speakerList">主讲人管理</a></li>
				<li><a href="${pageContext.request.contextPath}/Course/courseList">课程管理</a></li>
				<li><a target="pageBox" href="#">admin <span
						class="glyphicon glyphicon-log-out" aria-hidden="true">
					</span></a></li>
			</ul>
		</div>
	</nav>
	<div class="jumbotron">
		<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;课程列表--课程管理</h2>
	</div>
	<div style="margin-left: 150px;">
		<a class="btn btn-primary" href="${pageContext.request.contextPath}/Course/addcourse">添加课程</a>
	</div>

	<div class="bs-example" data-example-id="table-within-panel"></div>

	<table class="table"
		style="margin-left: 150px; margin-right: 30px; width: 1600px;">
		<thead>
			<tr>
				<th>序号</th>
				<th>标题</th>
				<th>学科</th>
				<th>简介</th>
				<th>编辑</th>
			</tr>
		</thead>
		<tbody>
		 <c:forEach var="c" items="${c}" varStatus="status">
			<tr>
				<th scope="row">${status.count}</th>
				<td>${c.courseName}</td>
				<td>${c.subject.subjectName}</td>
				<td>${c.courseDescr}</td>
				<td>
				<a href="<c:url value="/Course/editcourse?id="/>${c.id}"><span class="glyphicon glyphicon-edit" aria-hidden="blue"></span></a>
		&nbsp;<a href="<c:url value="/Course/deletecourse?id="/>${c.id}"><span class="glyphicon glyphicon-trash" aria-hidden="blue"></span></a>
			   </td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>