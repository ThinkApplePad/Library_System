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
    
    <title>My JSP 'SearchResult.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script>
		var authorinfo = new Array();
		var bookinfo = new Array();
		var brifeinfo = new Array();
		var total = 0;
		
		window.onload = function fuckjs() {
			<s:iterator value="authorlist" id="hehe">
				<s:iterator value="hehe" id = "str" status="st">
					authorinfo[<s:property value="#st.index"/>] = "<s:property value="str"/>";
				</s:iterator>
			</s:iterator>
			
			<s:iterator value="mylist" id="nimei">
				bookinfo[total] = new Array();
				<s:iterator value="nimei" id = "dd" status="tt">
					bookinfo[total][<s:property value="#tt.index"/>] = "<s:property value="dd"/>";
				</s:iterator>
				total += 1;
			</s:iterator>
			
			total = 0;
			
			<s:iterator value="brifeinfo" id="wocao">
				brifeinfo[total] = new Array();
				<s:iterator value="wocao" id = "qunimei" status="stt">
					brifeinfo[total][<s:property value="#stt.index"/>] = "<s:property value="qunimei"/>";
				</s:iterator>
				total += 1;
			</s:iterator>
			
			var Creat_table = document.getElementById("papapa");
			var INNER = "<table align='center' border='1' width='500'>";
			INNER += "<caption><h1>Here are the search results ~</h1></caption>";
			INNER += "<tr><th>Title</th><th>Author</th><th>Detail</th><th>Operate</th></tr>";
			
			for(var i=0; i<total; i++){
				INNER += "<tr><td>"+brifeinfo[i][0]+"</td>";
				INNER += "<td>"+brifeinfo[i][1]+"</td>";
				INNER += "<td><input value='click for details' type='button' onclick='javascript:plane("+i+")'/></td>";
				INNER += "<td><input value='delet' type='button' onclick='javascript:deelet("+i+")'/></td></tr>";	
			}
			INNER += "</table>";
			
			Creat_table.innerHTML = INNER;
		};
		
		function plane(i) {
			var b = "&nbsp&nbspThe AuthorID is ："+authorinfo[0]+"<br>&nbsp&nbspThe Name is ：" +authorinfo[1]+"<br> The Age is ："+authorinfo[2]+"<br>The Country is ："+authorinfo[3]+"<br>&nbsp&nbspThe ISBN is ："+bookinfo[i][0]+"<br>&nbsp&nbspThe Title is ："+bookinfo[i][1]+"<br>&nbsp&nbspThe Publisher is ："+bookinfo[i][3] + "<br>&nbsp&nbspThe PublishDate is ："+bookinfo[i][4]+"<br>&nbsp&nbspThe Price is ："+bookinfo[i][5];
			sAlert(b);
		}
		
		function deelet(i) {
			var Creat_form = document.getElementById("come");
			var twrite = "<form action='/Bookdelete' name='ganni' method='post'>";
			var bisbn = bookinfo[i][0];
			alert("Ready to delete a book whick ISBN is : "+bisbn);
			twrite += "<input type='hidden' name= 'bisbn' id='helpme' value="+bisbn+" />";
			twrite += "</form>";
        	Creat_form.innerHTML = twrite;
			tijiao();
		}
		
		function tijiao(){
			ganni.submit();
		}
		
	</script>
	
	<script>
			function sAlert(str) {
				var msgw, msgh, bordercolor;
				msgw = 400; //Width
				msgh = 300; //Height 
				titleheight = 100 //title Height
				bordercolor = "#336699"; //boder color
				titlecolor = "#99CCFF"; //title color

				var sWidth, sHeight;
				sWidth = document.body.offsetWidth;
				sHeight = screen.height;
				var bgObj = document.createElement("div");
				bgObj.setAttribute('id', 'bgDiv');
				bgObj.style.position = "absolute";
				bgObj.style.top = "0";
				bgObj.style.background = "#777";
				bgObj.style.filter = "progid:DXImageTransform.Microsoft.Alpha(style=3,opacity=25,finishOpacity=75";
				bgObj.style.opacity = "0.6";
				bgObj.style.left = "0";
				bgObj.style.width = sWidth + "px";
				bgObj.style.height = sHeight + "px";
				bgObj.style.zIndex = "10000";
				document.body.appendChild(bgObj);

				var msgObj = document.createElement("div")
				msgObj.setAttribute("id", "msgDiv");
				msgObj.setAttribute("align", "center");
				msgObj.style.background = "white";
				msgObj.style.border = "1px solid " + bordercolor;
				msgObj.style.position = "fixed";
				msgObj.style.left = "50%";
				msgObj.style.top = "50%";
				msgObj.style.font = "12px/1.6em Verdana, Geneva, Arial, Helvetica, sans-serif";
				msgObj.style.marginLeft = "-225px";
				msgObj.style.marginTop = -75 + document.documentElement.scrollTop + "px";
				msgObj.style.width = msgw + "px";
				msgObj.style.height = msgh + "px";
				msgObj.style.textAlign = "center";
				msgObj.style.lineHeight = "25px";
				msgObj.style.zIndex = "10001";

				var title = document.createElement("h4");
				title.setAttribute("id", "msgTitle");
				title.setAttribute("align", "right");
				title.style.margin = "0";
				title.style.padding = "3px";
				title.style.background = bordercolor;
				title.style.filter = "progid:DXImageTransform.Microsoft.Alpha(startX=20, startY=20, finishX=100, finishY=100,style=1,opacity=75,finishOpacity=100);";
				title.style.opacity = "0.75";
				title.style.border = "1px solid " + bordercolor;
				title.style.height = "18px";
				title.style.font = "12px Verdana, Geneva, Arial, Helvetica, sans-serif";
				title.style.color = "white";
				title.style.cursor = "pointer";
				title.innerHTML = "关闭";
				title.onclick = function() {
					document.body.removeChild(bgObj);
					document.getElementById("msgDiv").removeChild(title);
					document.body.removeChild(msgObj);
				}
				document.body.appendChild(msgObj);
				document.getElementById("msgDiv").appendChild(title);
				var txt = document.createElement("p");
				txt.style.margin = "1em 0"
				txt.setAttribute("id", "msgTxt");
				txt.innerHTML = str;
				document.getElementById("msgDiv").appendChild(txt);
			}
		</script>

  </head>
  
  <body style="background-color:#EED2EE">
  	<br>
	<div id="papapa">
	</div>
	<div id="come"></div>
	
    <form align="center">
    	<table >
    		<br><br><br><br>
    		<input type="button" value="Return" onclick="window.location='index.jsp'" />
   	 	</table>
    </form>
		
  </body>
</html>
