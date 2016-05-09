<%@page import="com.bbs.entity.user.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>帖子管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/datepicker3.css" rel="stylesheet">
<link href="css/bootstrap-table.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">

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
			<li><a href="BlogServlet?type=showMyBlogs&currentPage=1"><span
					class="glyphicon glyphicon-th"></span>我的帖子</a></li>

					<c:if test="${user.privilige==1}">
			<li><a href="ManageUserServlet?method=listUI"><span
					class="glyphicon glyphicon-list-alt"></span>用户管理 </a></li>
			<li class="active"><a href="ManagerBlogServlet?method=listUI"><span
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
	<!--/.sidebar-->

	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">帖子管理</li>
			</ol>
		</div>
		<!--/.row-->

		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">帖子管理</h1>
			</div>
		</div>
		<!--/.row-->

		<div class="row">
			<div class="col-lg-12">
				<table class="table table-bordered" align="center">
					<caption>
						<form action="manager/manager_listUI.action" method="post">
						    <input type="hidden" name="currentPage" value="0">
						    <input type="hidden" name="pageSize" value="2">
							<div class="input-group col-md-3">
							    <s:textfield cssClass="form-control input-md" id="btn-input"  name="title"></s:textfield>
								 <span class="input-group-btn">
									<button class="btn btn-success btn-md" id="query">查询</button>

								</span>
						</form>

					</caption>
					<thead>
						<tr align="center">
							<th><a class="btn btn-danger" id="deleteAll">批量删除</span></th>
							<th>标题</th>
							<th>发帖人</th>
							<th>发帖时间</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<form id="deletform" action="manager/manager_deleteAll.action">
							
							<c:forEach var="blog" items="${pagetUtils.pageData}">
								<tr align="center">
									<td width="12%"><input type="checkbox" name="blogIds"
										value="${blog.id}"></td>
									<td>${blog.title}</td>
									<td>${blog.useId}</td>
									<td>${blog.time}</td>
									<td><a
										href="manager/manager_delete.action?id=${blog.id}"
										class="btn btn-danger">删除</a></td>
								</tr>
							</c:forEach>
						</form>
					</tbody>
				</table>
			</div>
		</div>


	</div>

	<div class="row fixed-bottom">
		<div align="center">
			<nav>
			
			<ul class="pagination pagination-lg">
				<c:if test="${ pagetUtils.currentPage>1}">
			<li>
		
			<a href="manager/manager_listUI.action?currentPage=${pagetUtils.currentPage-1}" aria-label="Previous"> <span
						aria-hidden="true">&laquo;</span>
				</a></li>
				</c:if>
			<c:forEach var="i" begin="1" end="${pagetUtils.totalPage}">
				
				<li <c:if test="${pagetUtils.currentPage==i}">class="active"</c:if> >
				<a href="manager/manager_listUI.action?currentPage=${i}"><c:out value="${i}"></c:out></a></li>
				
				</c:forEach>
				<c:if test="${ pagetUtils.currentPage<pagetUtils.totalPage}">
				<li><a href="manager/manager_listUI.action?currentPage=${pagetUtils.currentPage+1}" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
				</c:if>
			</ul>
			
			</nav>
		</div>
	</div>
	</div>
	</div>
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/bootstrap-table.js"></script>
	<script>
		$("#deleteAll").on("click", function() {
			$("#deletform").submit();
		});

		!function($) {
			$(document)
					.on(
							"click",
							"ul.nav li.parent > a > span.icon",
							function() {
								$(this).find('em:first').toggleClass(
										"glyphicon-minus");
							});
			$(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
		}(window.jQuery);

		$(window).on('resize', function() {
			if ($(window).width() > 768)
				$('#sidebar-collapse').collapse('show')
		})
		$(window).on('resize', function() {
			if ($(window).width() <= 767)
				$('#sidebar-collapse').collapse('hide')
		})
	</script>
</body>

</html>

