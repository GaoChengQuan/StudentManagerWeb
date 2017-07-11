<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'online_student_list.jsp' starting page</title>
    <link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css" />
	<script src="lib/jquery/jquery-1.11.1.js" type="text/javascript"
	charset="utf-8"></script>
	<script src="lib/bootstrap/js/bootstrap.js" type="text/javascript"
	charset="utf-8"></script>
  </head>
  
  <body>
    <div class="container" style="width:70%">
		<jsp:include page="header.jsp"></jsp:include>
		在线用户：
		<table class="table table-bordered table-hover table-striped">
			<tr>
				<td>ID</td>
				<td>姓名</td>
				<td>密码</td>
				<td>年龄</td>
				<td>性别</td>
			</tr>
			<c:forEach items="${onlineStudentList}" var="student">
				<tr>
					<td>${student.getId()}</td>
					<td>${student.getName()}</td>
					<td>${student.getPassword()}</td>
					<td>${student.getAge()}</td>
					<td>${student.getGender()}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
