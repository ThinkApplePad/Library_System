<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'whethertoadd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>
  
	<body style="background-color:#D1EEEE">
    	<form action="/Addbook" method="post">
      	<table align="center">
      		<caption><h1>Add a new Book </h1></caption>
      		<tr>
      			<td>ISBN：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="isbn"/></td>
      		</tr>
      		<tr>
      			<td>Title：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="title"/></td>
      		</tr>
      		<tr>
      			<td>AuthorName：&nbsp<input type="text" name="authorname"/></td>
      		</tr>
      		<tr>
      			<td>AuthorID：&nbsp&nbsp&nbsp<input type="text" name="authorid"/></td>
      		</tr>
      		<tr>
      			<td>AuthorAge：&nbsp&nbsp<input type="text" name="age"/></td>
      		</tr>
      		<tr>
      			<td>Country：&nbsp&nbsp&nbsp&nbsp<input type="text" name="country"/></td>
      		</tr>
      		<tr>
      			<td>Publisher：&nbsp&nbsp<input type="text" name="publisher"/></td>
      		</tr>
      		<tr>
      			<td>PublishDate：<input type="text" name="publishdate"/></td>
      		</tr>
      		<tr>
      			<td>Price：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="price"/></td>
      		</tr>
      		<tr>
      			<td><br><br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="button" value="Return" onclick="window.location='index.jsp'" />&nbsp&nbsp&nbsp<input type="submit" value="Add"/></td>
      		</tr>
      	</table>
   	</form>
	</body>



</html>
