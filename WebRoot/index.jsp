<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
  <br><br><br><br><br>
  <body style="background-color:#E0EEEE">
   	<form action="/Authorsearch" method="post" align="center">
      	<table align="center">
      		<caption><h1>My Library System</h1></caption>
      		<tr>
      			<td>Author：<input type="text" name="authorname"/></td>
      			<td><input type="submit" value="Click me"/></td>
      		</tr>
      	</table>
   	</form>   	
   	<form method="post" align="center">
   		<table>
      		<tr>
     			<br /><br /><br />
     			<input type="button" value="New Book" onclick="window.location='whethertoadd.jsp'" /> 
      		</tr>
      	</table>
   	</form>
  </body>
</html>
