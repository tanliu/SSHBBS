<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>账号注册界面</title>
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
   <%
 if(session.getAttribute("Uname")==null){
        session.setAttribute("Uname","true");
}
if(session.getAttribute("Pwd")==null){
        session.setAttribute("Pwd","true");
}
if(session.getAttribute("Email")==null){
        session.setAttribute("Email","true");
}
    
  %>
    <form name="login" action="UserRegisterServlet" method="post">
     <h2>BBS用户注册</h2>
       <p>用户名:<input name="username" type="text" style="height:30px;width:300px">  &nbsp;&nbsp;<% if(!session.getAttribute("Uname").equals("true")) out.print("用户名不能为空");%><br/>
           <br/>
           密&nbsp;&nbsp;码:<input name="password" type="password" style="height:30px;width:300px" >  &nbsp;&nbsp;<% if(!session.getAttribute("Pwd").equals("true")) out.print("密码不能为空");%><br/>
           <br/>
         邮&nbsp;&nbsp;箱:<input name="email" type="text" style="height:30px;width:300px" >  &nbsp;&nbsp;<% if(!session.getAttribute("Email").equals("true")) out.print("邮箱格式不正确");%><br/>
           <br/>
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="注册" style="  background:green;color:white;width: 100px; height: 30px;border:0; font-size:19px" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="reset" value="取消" style="  background:green;color:white;width: 100px; height: 30px;border:0; font-size:19px" ></p>
    </form>
  </body>
</html>
