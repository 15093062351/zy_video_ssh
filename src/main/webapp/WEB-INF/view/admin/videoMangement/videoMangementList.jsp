<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="lyb" uri="http://zhiyou100.com/common/" %>
<%-- created by zhouyanchao on 2017年7月11日 下午5:04:04 --%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>视频列表 - 视频管理</title>
<link href="${pageContext.request.contextPath }/ss/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/ss/css/jquery-confirm.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath }/ss/js/jquery-1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath }/ss/js/jquery-confirm.min.js"></script>
<script type="text/javascript">
/*
 * 声明一个变量 初始化是0 
 */

 var deleteNum = 0; 
 function checkDelete(ele){
	 if(ele.checked){
		 deleteNum++;
	 }else{
		 deleteNum--;
	 }
	 $("#countSpan").text(deleteNum);
	 if( deleteNum == $("input[name=checkid]").length){
		 $("#checkAll").prop("checked",true);
	 }else{
		 $("#checkAll").prop("checked",false);
	 }
	 
 }
 
 function checkAllElement(ele){
	 $("input[name=checkid]").prop("checked",ele.checked);
	 if(ele.checked){
		 deleteNum = $("input[name=checkid]").length;
	 }else{
		 deleteNum = 0;
	 }
	 $("#countSpan").text(deleteNum);
 }
 
 
 function batchDelete(){
	 if(deleteNum == 0){
		 $.alert({
			    title: '警告',
			    content: '没选中,删什么删',
			});
		 return;
	 }
	 $.confirm({
		    title: '提示',
		    content: '看清哦,可是全部删除!!',
		    buttons: {
		        confirm: {
		        	text: '非常肯定',
	
		        	action: function () {
		           		$("#deleteForm").submit();
		        	}
		        },
		                 取消: function () {
		           
		        }
		       
		    }
		});
 }
 
 function deleteInfo(id){
	 $.confirm({
		    title: '提示',
		    content: '是否确认',
		    buttons: {
		        confirm: {
		        	text: '非常肯定',
		        	action: function () {
		           		$.ajax({
		           			url:"${pageContext.request.contextPath}/Video/deletevideo",
		           			dataType:"text",
		           			type:"post",
		           			data:{"id":id},
		           			success:function(msg){
		           				if(msg=="success"){
		           					location.reload();
		           				}
		           			}
		           		});
		        	}
		        },
		                 取消: function () {
		           
		        }
		       
		    }
		});
	 
	 
	 
 }
 

</script>
</head>
<body>
	<!-- 引入公用的导航信息 -->
	 <jsp:include page="/WEB-INF/view/admin/header.jsp">
		<jsp:param value="video" name="fromJsp"/>
	</jsp:include>


	<div class="container">
		<div class="jumbotron">
  			<h2>视频列表 - 视频管理</h2>
		</div>
		<div class="row">
		<a href="${pageContext.request.contextPath }/Video/videoadd" class="btn btn-primary">添加视频</a>
		<button class="btn btn-primary" type="button" onclick="batchDelete()">
		  批量删除 <span class="badge" id="countSpan">0</span>
		</button>
		<div style="float: right;">
			<form class="form-inline" action="${pageContext.request.contextPath }/Video/videoList" method="post">
			  <div class="form-group">
			    <input type="text" class="form-control" name="queryName"  value="${queryName }" placeholder="视频标题">
			  </div>
			   <div class="form-group">
			    <select name="speakerId"  class="form-control">
			    	<option value="0">请选择主讲人</option>
			    	<c:forEach items="${speakers }" var="sp">
			    		<option  ${speakerId == sp.id ? "selected": ""} value="${sp.id }">${sp.speakerName }</option>
			    	</c:forEach>
			    </select>
			  </div>
			  
			  <div class="form-group">
			    <select name="courseId" class="form-control">
			    	<option value="0">请选择课程</option>
			    	<c:forEach items="${courses }" var="c">
			    		<option  ${courseId == c.id ? "selected": ""} value="${c.id }">${c.courseName }</option>
			    	</c:forEach>
			    </select>
			  </div>
			  
			  <button type="submit" class="btn btn-primary">查询</button>
			</form>
		</div>
		</div>
	   <form action="${pageContext.request.contextPath }/Video/batchDelete" id="deleteForm" method="get">
		<table class="table table-hover">
 			<thead>
 				<tr>
 					<th><input type="checkbox" id="checkAll" onclick="checkAllElement(this)"></th>
 					<th>序号</th>
 					<th>名称</th>
 					<th>介绍</th>
 					<th>讲师</th>
 					<th>课程</th>
 					<th>时长(秒 )</th>
 					<th>播放次数</th>
 					<th>编辑</th>
 					<th>删除</th>
 				</tr>
 			</thead>
 			<tbody>
 				<c:if test="${not empty pages.rows }">
 					<c:forEach items="${pages.rows }" var="sp" varStatus="i">
		 				<tr>
		 					<td><input type="checkbox" name="checkid" value="${sp.id }" onclick="checkDelete(this)"> </td>
		 					<td>${i.index+1 }</td>
		 					<td>${sp.videoTitle }</td>
		 					<td>${sp.videoDescr }</td>
		 					<td>${sp.speaker.speakerName }</td>
		 					<td>${sp.course.courseName }</td>
		 					<td>${sp.videoLength}</td>
		 					<td>${sp.videoPlayTimes }</td>
		 					<td><a href="${pageContext.request.contextPath }/Video/updatevideo?id=${sp.id }"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>
		 					<td><a href="${pageContext.request.contextPath }/Video/deletevideo?id=${sp.id }" onclick="deleteInfo(${sp.id})"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>
		 				</tr>
	 				</c:forEach>
 				</c:if>
 				<c:if test="${empty pages.rows }">
 					<tr><td>当前查询结果为空!</td></tr>
 				</c:if>
 			</tbody>
		</table>
		<lyb:page url="${pageContext.request.contextPath }/Video/videoList"></lyb:page>
	</form>
</div>

<script src="${pageContext.request.contextPath }/ss/js/jquery-1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath }/ss/js/jquery-confirm.min.js"></script>
<script>

	
</script>


</body>
</html>