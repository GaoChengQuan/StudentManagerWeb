<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	isErrorPage="true"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'error.jsp' starting page</title>
</head>

<body>
	错误处理界面。
	<br />
	<%=exception.toString()%>

	<%-- <%
		response.getWriter().println("Exception: " + exception);
		if (exception != null) {
			response.getWriter().println("<pre>");
			exception.printStackTrace(response.getWriter());
			response.getWriter().println("</pre>");
		}
		response.getWriter().println("<hr/>");
	%> --%>
</body>
</html>
