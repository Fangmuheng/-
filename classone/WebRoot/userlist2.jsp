<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userlist2.jsp' starting page</title>
    
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
	<form action="servlet/Exam1Servlet" method="post">
    		ID:<input type = "text" name = "id" value="${user.id}"/>
    		用户名：<input type = "text" name = "username" value="${user.username}"/>
    		年龄：<input type = "text" name = "age" value="${user.age}"/>
    		<input type = "submit" name = "搜索"/>
    	</form>
    	<table border = "1" >
    		<tr>
    			<td>Id</td>
    			<td>用户名</td>
    			<td>密码</td>
    			<td>年龄</td>
    			<td>编辑</td>
<!--     			<td>删除</td> -->
    		</tr>
    		<!-- EL表达式  前台页面接值  ：作用域 session(一次会话)  只要不关闭浏览器，信息就保存在session里
    		 request response page   (jsp内置对象)-->
    		<c:forEach items="${userlist}" var="list">
    		
    		<tr>
    			<td>${list.id}</td>
    			<td>${list.username}</td>
    			<td>${list.password}</td>
    			<td>${list.age}</td>
    			<!-- get方法提交 -->
    			<td><a href="servlet/UserUpdateServlet?id=${list.id}">编辑</a></td>
    			<%-- <td><a href="servlet/UserDeleteServlet?id=${list.id}">删除</a></td> --%>
    		</tr>
    		</c:forEach>
    	</table>
    	<a href="useradd.jsp">增加</a>
    </div>
  </body>
</html>
