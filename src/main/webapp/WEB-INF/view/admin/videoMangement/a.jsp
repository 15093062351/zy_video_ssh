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

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">

<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="static/JQuery/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
 	var k=0;
 	function qx(t)
{
	var cd = document.getElementsByTagName("input");
	k=cd.length-2;
	for(var i = 2 ; i<cd.length ; i++){
     var ci= document.getElementsByTagName("input")[i].checked;   
     var arr=t.checked;
    if(ci!=arr){
    	ci= document.getElementsByTagName("input")[i].click();
    }
	
	}
}

function fx()
{
	var cd = document.getElementsByTagName("input");
	for(var i = 2 ; i<cd.length ; i++){
      document.getElementsByTagName("input")[i].click();;
	}
}

function allsubmit() 
{
	
	document.getElementsByName("dong")[0].submit();
	alert("88");
	}




</script>

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
<body>
	<nav class="navbar navbar-inverse">
		<div style="margin-left: 150px;">
			<ul class="nav navbar-nav">
				<li><a href="#">视频管理系统</a></li>
				<li><a href="${pageContext.request.contextPath}/admin/adminPage.action">视频管理</a></li>
				<li><a href="${pageContext.request.contextPath}/admin/speakerList.action">主讲人管理</a></li>
				<li><a href="${pageContext.request.contextPath}/admin/courseList.action">课程管理</a></li>
				<li><a href="#">统计分析</a></li>
				<li><a target="pageBox"  href="#">admin
    <span class="glyphicon glyphicon-log-out" aria-hidden="true"><!-- <a target="pageBox"  href="#">退出 --></span></a> </li>
			</ul>
		</div>
	</nav>
	<div class="jumbotron">
		<h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;课程列表--课程管理</h2>
	</div>
	<div style="margin-left: 150px;">
		<a class="btn btn-primary" href="${pageContext.request.contextPath}/admin/addVideo.action">添加视频</a> 
		<a href="" onclick="allsubmit()"><button class="btn btn-primary" type="button">批量删除 <span class="badge"></span></button>
		</a>

		<form id="searchForm"action="${pageContext.request.contextPath}/admin/adminPage.action">
			<div style="margin-left: 300px;">
				<input type="text" name="videoTitle"    placeholder="视频标题">
				<select name="adminSearchSperker">
				<option value="">请选择主讲人</option>
					<c:forEach var="list" items="${list}" varStatus="status">
						<option value="${list.id}">${list.speakerName}</option>
					</c:forEach>
				</select> 
				<select name="adminSearchCourse">
					<option value="">请选择课程</option>
					<c:forEach var="course" items="${course}" varStatus="status">
						<option value="${course.id}">${course.courseName}</option>
					</c:forEach>
				</select> <input type="submit" class="btn btn-primary" value="查询">
			</div>
		</form>
		
		<div class="bs-example" data-example-id="table-within-panel"></div>
		
		
		<form action="${pageContext.request.contextPath}/admin/muiltdeleteVideo.action" name="dong" method="post">
		<table class="table" style="margin-left: 30px; margin-right: 30px; width: 1600px;">
			<thead>
				<tr>
					<th><input type="checkbox" onclick="qx(this)"></th>
					<th>序号</th>
					<th>名称</th>
					<th>介绍</th>
					<th>讲师</th>
					<th>课程</th>
					<th>时长(秒)</th>
					<th>播放次数</th>
					<th>编辑</th>
				</tr>
			</thead>
			<tbody>
			 <c:forEach var="video" items="${page.rows }" varStatus="status">
				<tr>
					<td><input type="checkbox" name="ids" value="${video.id }"></td>
					<td scope="row">${status.count +((page.page-1)*5)}</td>
					<td>${video.videoTitle}</td>
					<td>${video.videoDescr}</td>
					<td>${video.speaker.speakerName}</td>
					<td>${video.course.courseName}</td>
					<td>${video.videoLength}</td>
					<td>${video.videoPlayTimes}</td>
					<td>
					 <a href="<c:url value="/admin/editVideo.action?id="/>${video.id}"><span class="glyphicon glyphicon-edit"
							aria-hidden="blue"> </span></a> 
							&nbsp; <a href="<c:url value="/admin/deleteVideo.action?id="/>${video.id}"><span class="glyphicon glyphicon-trash" aria-hidden="blue"></span></a> 
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<input type="hidden" name="submit">
     </form>
     
     
     
	</div>
<ll:page url="${pageContext.request.contextPath}/admin/adminPage.action"></ll:page>
</body>
</html>