<%@ page language="java" import="java.util.*,com.bbs.utils.*,com.bbs.entity.blog.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
   PageUtils<Blog> blogPageUtils=(PageUtils<Blog>)request.getAttribute("blogPageUtils");
		 %>	
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Lumino - Dashboard</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/datepicker3.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">

<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<script src="js/respond.min.js"></script>
<![endif]-->

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
			<li ><a href="BlogServlet?type=showBlogs&currentPage=1"><span
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

	</div>
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">我的帖子</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-8">
				<h1 class="page-header">我的帖子</h1>
			</div>
            <div class="col-lg-4" align="right" style="margin-top:30px;"><a href="BlogServlet?type=publish&use_id=1" class="btn btn-danger">我要发帖</a></div>
		</div><!--/.row-->
        

			
		<div class="row">
			<div class="col-md-12">
			
				<div class="panel panel-default chat">
					<div class="panel-heading" id="accordion"><span class="glyphicon glyphicon-comment"></span> Chat</div>
					<div class="panel-body">
							<%
					for(int i=0;i<blogPageUtils.getPageData().size();i++){
					 %>
						<ul>
							<li class="left clearfix">
								<span class="chat-img pull-left">
									<img src="http://placehold.it/80/30a5ff/fff" alt="User Avatar" class="img-circle" />
								</span>
								<div class="chat-body clearfix">
									<div class="header">
										<strong class="primary-font">作者：<%=blogPageUtils.getPageData().get(i).getUseId()%></strong> <small class="text-muted"><%=blogPageUtils.getPageData().get(i).getTime() %></small>
									</div>
									<p>
										<%=blogPageUtils.getPageData().get(i).getTitle() %>
									</p>
									<div align="right"><a href="BlogServlet?type=delBlogs&pub_id=<%=blogPageUtils.getPageData().get(i).getId() %>" class="btn btn-default">删除</a><a href="BlogServlet?type=goalterBlogs&pub_id=<%=blogPageUtils.getPageData().get(i).getId()%>" class="btn btn-default">更改</a></div>
								</div>
							</li>

						</ul>
                       <%
                       }
                        %>				
					</div>
					

				</div>
				
			</div><!--/.col-->
			

		</div><!--/.row-->
           <div class="row fixed-bottom">
                    <div align="center">
                      <nav>
                       <ul class="pagination pagination-lg">
                         <% if(blogPageUtils.getTotalPage()>1&&blogPageUtils.getCurrentPage()>1){%> <li><a href="BlogServlet?type=showMyBlogs&currentPage=<%=blogPageUtils.getCurrentPage()-1 %>" aria-label="Previous"> <span aria-hidden="true">&raquo;</span> </a></li>
                         <%} %>
                         <%
                         for(int i=1;i<=blogPageUtils.getTotalPage();i++){
                           if(blogPageUtils.getCurrentPage()==i){
                          %>
                         <li class="active"><a href="BlogServlet?type=showMyBlogs&currentPage=<%=i%>"><%=i %></a></li>
                         <%
                         }
                         else{
                         %>  
                         <li><a href="BlogServlet?type=showMyBlogs&currentPage=<%=i%>"><%=i %></a></li>
                         <% 
                         }
                         }
                          %>
                           <%if(blogPageUtils.getTotalPage()>1&&blogPageUtils.getCurrentPage()<blogPageUtils.getTotalPage()){ %><li><a href="BlogServlet?type=showMyBlogs&currentPage=<%=blogPageUtils.getCurrentPage()+1 %>" aria-label="Next"> <span aria-hidden="true">&raquo;</span> </a></li>
                      
                      <%} %>
                        </ul>
                      </nav>
                    </div>
                  </div>
                </div>
              </div>
	</div>	<!--/.main-->

	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script>
		$('#calendar').datepicker({
		});

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
