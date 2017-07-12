<%@page import="com.situ.student.entity.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'student_list.jsp' starting page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css" />
<script src="lib/jquery/jquery-1.11.1.js" type="text/javascript"
	charset="utf-8"></script>
<script src="lib/bootstrap/js/bootstrap.js" type="text/javascript"
	charset="utf-8"></script>
<script type="text/javascript">
	function delStudent(id) {
		var isDel = confirm("您确认要删除吗？");
		if (isDel) {
			//要删除
			location.href = "${pageContext.request.contextPath}/student?method=delete&id="
					+ id;
		}
	}
	
	function goPage(pageIndex) {
		$("#pageIndex").val(pageIndex);
		$("#searchForm").submit();
	}
	
	$(function(){
		$("#gender option[value='${searchCondition.gender}']").prop("selected", true);
	});
	
	function selectAlls() {
		$("input[name=selectIds]").prop("checked", $("#selectAll").is(":checked"));
	}
	
	function deleteAll(){
		var isDel = confirm("您确认要删除吗？");
		if (isDel) {
			//要删除
			$("#mainForm").attr("action", "${pageContext.request.contextPath}/student?method=deleteAll");
			$("#mainForm").submit();
		}
	}
</script>
</head>
<body>
	<div class="container" style="width:70%">
		<jsp:include page="header.jsp"></jsp:include>
		<div>
			<form id="searchForm" action="${pageContext.request.contextPath}/student?method=searchByCondition" method="post">
				<input type="hidden" name="pageIndex" id="pageIndex"/>
				姓名:<input type="text" name="name" value="${searchCondition.name}"/>
				年龄:<input type="text" name="age" value="${searchCondition.age}"/>
				性别:<select id="gender" name="gender">
						<option value="">不限</option>
						<option value="男">男</option>
						<option value="女">女</option>
				    </select>&nbsp;&nbsp;&nbsp;
				<button type="submit" class="btn btn-primary">搜索</button>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a class="btn btn-primary"
					href="javascript:deleteAll()">批量删除</a>
				<a class="btn btn-primary"
					href="${pageContext.request.contextPath}/add_student.jsp">添加学生</a>
				<a class="btn btn-primary"
					href="${pageContext.request.contextPath}/student?method=pageList">查询所有</a>
				<a class="btn btn-primary"
					href="${pageContext.request.contextPath}/student?method=onlineList">在线列表</a>
			</form>
		</div>
		<form id="mainForm" action="" method="post">
			<table class="table table-bordered table-hover table-striped">
				<tr>
					<td>
						<input type="checkbox" id="selectAll" onClick="selectAlls();"/>
					</td>
					<td>ID</td>
					<td>姓名</td>
					<td>密码</td>
					<td>年龄</td>
					<td>性别</td>
					<td>出生日期</td>
					<td>删除</td>
					<td>修改</td>
				</tr>
				<c:forEach items="${pageBean.list}" var="student">
					<tr>
						<td>
							<input type="checkbox" name="selectIds" value="${student.getId()}"/>
						</td>
						<td>${student.getId()}</td>
						<td>${student.getName()}</td>
						<td>${student.getPassword()}</td>
						<td>${student.getAge()}</td>
						<td>${student.getGender()}</td>
						<td>${student.getBirthday()}</td>
						<td><a href="javascript:void(0);"
							onclick="delStudent('${student.getId()}')">删除</a>
						</td>
						<td><a
							href="${pageContext.request.contextPath}/student?method=toUpdate&id=${student.getId()}">修改</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</form>
		<!-- 分页开始 -->
		<nav aria-label="Page navigation" align="center">
		  <ul class="pagination">
		  	<!-- 上一页 -->
		  	<!-- 判断是否是第一页，是第一页就让一个li设置class=disable -->
		  	 <c:if test="${pageBean.pageIndex==1}">
			  	 <li class="disabled">
			      <a href="javascript:void(0);">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
		  	 </c:if>
		  	<c:if test="${pageBean.pageIndex!=1}">
			    <li>
			      <a href="javascript:goPage('${pageBean.pageIndex-1}');" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
		    </c:if>
		    
		    <c:forEach begin="1" end="${pageBean.totalPage}" var="page">
		    	<c:if test="${pageBean.pageIndex==page}">
			    	<li class="active"><a href="javascript:void(0);">${page}</a></li>
		    	</c:if>
		    	<c:if test="${pageBean.pageIndex!=page}">
			    	<li><a href="javascript:goPage('${page}');">${page}</a></li>
		    	</c:if>
		    </c:forEach>
		    
		    
		    <!-- 上一页 -->
		  	<!-- 判断是否是第一页，是第一页就让一个li设置class=disable -->
		  	 <c:if test="${pageBean.pageIndex==pageBean.totalPage}">
			  	 <li class="disabled">
			      <a href="javascript:void(0);">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
		  	 </c:if>
		  	<c:if test="${pageBean.pageIndex!=pageBean.totalPage}">
			    <li>
			      <a href="javascript:goPage('${pageBean.pageIndex+1}');" aria-label="Previous">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
		    </c:if>
		  </ul>
		</nav>
		<!-- 分页结束 -->
	</div>
</body>
</html>
