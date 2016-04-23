<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
    
    <title>账号登录界面</title>
    <style type="text/css">
form{
padding-top:180px;
padding-left:500px;
}
p{
font-size:24px;
}
    </style>
  </head>
  <body>
    <form name="login" action="UserloginServlet" method="post">
     <input type="hidden" name="method" value="login">
     <h2>BBS论坛登录</h2>
       <p>  用户名:<input name="username" type="text" style="height:30px;width:300px"><br/>
           <br/>
           密&nbsp;&nbsp;码:<input name="password" type="password" style="height:30px;width:300px" ><br/>
           <br/>
           &nbsp;<input type="submit" value="登录" style="  background:green;color:white;width: 100px; height: 30px;border:0; font-size:19px" >&nbsp;&nbsp;没有账号？<a href="register.jsp">在此注册</a></p>
    </form>
  </body>
</html>
