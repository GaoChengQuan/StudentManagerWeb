<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'login.jsp' starting page</title>
    <script src="${pageContext.request.contextPath}/lib/jquery/jquery-1.11.1.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
    	function refreshCode(){
    		document.getElementById("codeImage").src="${pageContext.request.contextPath}/checkImg?" + Math.random();
    	}
    </script>
  </head>
  
  <body>
	<form action="${pageContext.request.contextPath}/loginFilter?method=login" method="post">
		用戶名：<input type="text" name="name"/><br/>
		密码：<input type="text" name="password"/><br/>
		验证码:<input type="text" name="checkCode"/> <img id="codeImage" src="${pageContext.request.contextPath}/checkImg" onclick="refreshCode();"> <br/>
		<input type="submit" value="登陆"/>
	</form>
  </body>
</html>
