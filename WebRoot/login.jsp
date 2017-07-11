<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'login.jsp' starting page</title>
  </head>
  
  <body>
  	<form action="${pageContext.request.contextPath}/loginFilter?method=login" method="post">
  		用戶名：<input type="text" name="name"/><br/>
  		密码：<input type="text" name="password"/><br/>
  		<input type="submit" value="登陆"/>
  	</form>
  </body>
</html>
