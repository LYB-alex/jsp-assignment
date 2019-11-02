<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="myBean.userinfo" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:useBean id="userinfoBean" class="myBean.userinfo" scope="session"/>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
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
        用户 ${userinfoBean.username}欢迎登录<br>
    <form name="form1" action="myServlet/QueryServlet" method="post">
    <input type="text" name="Querymessage" value="请输入关键字"/>
    <input type="submit"  value="查询"/> 
    </form>
    <form name="form2" action="myServlet/modify" method="post">
    <table bgColor="#c0c0c0" name="UserTable">
    <tr><td>用户id</td><td>用户姓名</td><td>用户密码</td></tr>
   <%
   List<userinfo> list=userinfoBean.getList();
   Iterator<userinfo> it=list.iterator();
   
   String username,password;
   int userID;
   while(it.hasNext()){
   userinfo user=it.next();
   username=user.getUsername();
   password=user.getPassword();
   userID=user.getId();
   out.print("<tr><td><input type='text' value='"+userID+"' name='id'></td>");
   out.print("<td><input type='text' value='"+username+"' name='username'></td>");
   out.print("<td><input type='text' value='"+password+"' name='password'></td>");
   out.print("<td><input type='submit' value=更改 '></td>");
   out.print("<td><a href='myServlet/Delete?id="+userID+"'>删除</a></td>");
   out.print("</tr>");
   }
    %>
    </table>
    </form>
  </body>
</html>
