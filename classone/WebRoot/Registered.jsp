<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Registered.jsp' starting page</title>
    
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
  	<div align = "center">
   		 <form action="">
   		 <fieldset>
   		 <legend>注册新用户</legend>
   		 	用户名:<input type = "text" name = "username"/><br>
   		 	性别: 男<input type = "radio" checked = "checked" name = "sex" value="male"/>
   		 	女<input type = "radio" name = "sex" value="female"/><br>
   		 	年龄:<select name="age">
					<option value="1">30以上</option>
					<option value="2">18-30</option>
					<option value="3">10-18</option>
					<option value="4">18以下</option>
					<option value="null" selected="selected">不想填</option>
				</select><br>
			密码:<input type = "password" name = "password"/><br>
			再输入一次:<input type = "password" name = "password"/><br>
			兴趣爱好: 绘画<input type="checkbox" name = "hobby" value="draw"/><br />
			写作<input type="checkbox" name = "hobby" value="write"/><br />
			敲代码=。=<input type="checkbox" name = "hobby" value="code"/><br />
			没有兴趣爱好<input type="checkbox" name = "hobby" value="null" checked="checked"/><br />
			自我介绍：<textarea rows="10" cols="10"> </textarea>
			</fieldset>
   		 </form>
    </div>
  </body>
</html>
