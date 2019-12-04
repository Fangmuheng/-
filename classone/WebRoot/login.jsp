<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>login</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

		<!-- 
		1.前台用户填写信息
		2.后台接收登录信息 servlet
		3.利用接取到的数据进行数据库查询 (用户点登陆->通过action路径到web.xml->找到servlet-mapping标签，在里面找到servlet-name
		->在servlet中找到和刚才那个servlet-name一样的->根据class路径找到Servlet类，进行数据接收)
		-->
		
  </head>
  
  <body>
    <div align="center">
     	 <!-- url-pattern中的路径 -->
    	<form action="servlet/UserServlet" method="post">
    		用户名：<input type = "text" name = "username"/><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    		密码：<input type = "password" name = "password"/>
    		<input type = "submit" name = "登录"/>
    		
    	</form>
    </div>
  </body>
</html>
