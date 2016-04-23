<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Lumino - Forms</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/datepicker3.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">

<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<script src="js/respond.min.js"></script>
<![endif]-->
<script type="text/javascript">
 function alert2(){
  
    alert("无语了");
    return false;
   }
  
   
  /*  if(title.length ==0||title.match(/^\s+$/g)){
    alert("回复的标题不能为空");
    return false;
   }*/
  
   
  

</script>
</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#sidebar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"><span>BBS</span>论坛</a>
			<ul class="user-menu">
				<li class="dropdown pull-right"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"><span
						class="glyphicon glyphicon-user"></span> ${user.username} <span class="caret"></span></a>
					 <c:if test="${user!=null}">
					<ul class="dropdown-menu" role="menu">
						<li><a href="UserloginServlet?method=loginout"><span class="glyphicon glyphicon-log-out"></span>
								退出</a></li>
					</ul>
					</c:if>
					</li>
			</ul>
		</div>

	</div>
	<!-- /.container-fluid --> </nav>

	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<ul class="nav menu">
			<li><a href="BlogServlet?type=showBlogs&currentPage=1"><span
					class="glyphicon glyphicon-dashboard"></span>浏览帖子</a></li>
			 <c:if test="${user!=null}">
			<li class="active"><a href="BlogServlet?type=showMyBlogs&currentPage=1"><span
					class="glyphicon glyphicon-th"></span>我的帖子</a></li>

					<c:if test="${user.privilige==1}">
			<li><a href="ManageUserServlet?method=listUI"><span
					class="glyphicon glyphicon-list-alt"></span>用户管理 </a></li>
			<li><a href="ManagerBlogServlet?method=listUI"><span
					class="glyphicon glyphicon-pencil"></span>帖子管理</a></li>
					</c:if>
            </c:if>

             <c:if test="${user==null}">
			<li role="presentation" class="divider"></li>
			<li><a href="login.jsp"><span
					class="glyphicon glyphicon-user"></span> 用户登录</a></li>
			</c:if>
		</ul>

	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">发贴</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">发贴</h1>
			</div>
		</div><!--/.row-->
				
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">

					<div class="panel-body">
						<form role="form" action="BlogServlet?type=addBlog" method="post">
						<div class="col-md-8">

							
								<div class="form-group">
									<label>标题</label>
									<input id="title1" class="form-control" name="title">
								</div>
																
								
								
								<div class="form-group">
									<label>发布的内容</label>
									<textarea id="content1" class="form-control" rows="3" name="content"></textarea>
								</div>
								<input type="submit" class="btn btn-danger" value="发送" oncick="return alert2()">
								</div>
														
						</form>	
							</div>

					</div>
				</div>
			</div><!-- /.col-->
		</div><!-- /.row -->
		
	</div><!--/.main-->

	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script>
		!function ($) {
			$(document).on("click","ul.nav li.parent > a > span.icon", function(){		  
				$(this).find('em:first').toggleClass("glyphicon-minus");	  
			}); 
			$(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
		}(window.jQuery);

		$(window).on('resize', function () {
		  if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
		})
		$(window).on('resize', function () {
		  if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
		})
	</script>	
</body>

</html>
