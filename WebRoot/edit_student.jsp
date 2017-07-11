<%@page import="com.situ.student.entity.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css" />
    <script src="${pageContext.request.contextPath}/lib/jquery/jquery-1.11.1.js" type="text/javascript" charset="utf-8"></script>
	<script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
	<div class="container" style="width:40%">
		<h2>修改学生信息</h2>
		<form
			action="${pageContext.request.contextPath}/student?method=update" method=post>
			<input type="hidden" name="id" value="${student.getId()}">
			<div class="form-group">
				<label for="name">姓名</label> 
				<input type="text" class="form-control"
					id="name" name="name" value="${student.getName()}">
			</div>
			<div class="form-group">
				<label for="password">密码</label> 
				<input type="text" class="form-control"
					id="password" name="password" value="${student.getPassword()}">
			</div>
			<div class="form-group">
				<label for="age">年龄</label>
				<input type="text" class="form-control"
					id="age" name="age" value="${student.getAge()}">
			</div>
			<div class="form-group">
				<label for="gender">性别</label>
				<input type="text"
					class="form-control" id="gender" name="gender"
					value="${student.getGender()}">
			</div>
			<button type="submit" class="btn btn-primary">确认修改</button>
		</form>
	</div>
</body>
</html>
