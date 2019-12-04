<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'useradd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div align="center">
     	 <!-- url-pattern中的路径 -->
    	<form action="servlet/UserAddServlet" method="post">
    		用户名：<input type = "text" name = "username"/><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    		密码：<input type = "password" name = "password"/><br>
    		年龄：<input type = "text" name="age"/>
    		<input type = "submit" name = "提交"/>
    		
    	</form>
    </div>
  </body>
</html>
