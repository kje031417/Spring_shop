<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.98.0">
    <title>Home</title>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/dashboard/">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link href="/resources/css/dashboard.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
 	<link href="/resources/css/notice.css" rel="stylesheet">
 	<link href="/resources/css/noticeForm.css" rel="stylesheet">
 	<link href="/resources/css/signup.css" rel="stylesheet">
 	<link href="/resources/css/signin.css" rel="stylesheet">
 	<link href="/resources/css/gallery.css" rel="stylesheet">
 	<script src="/resources/js/signin.js"></script>
 	<script src="/resources/js/signup.js"></script>
 	<script src="/resources/js/notice.js"></script>
 	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
 	<script  src="/resources/js/jquery-1.12.4.min.js"></script>
 	<script  src="/resources/js/jquery.ui.paging.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script>
  </head>
  <body>
	<header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
		<a class="navbar-brand col-md-3 col-lg-2 me-0 px-3 fs-6" href="#">Company name</a>
		<input class="form-control form-control-dark w-70 rounded-0 border-0"
			type="text" placeholder="Search" aria-label="Search">
		<div class="navbar-nav">
			<div class="nav-item text-nowrap">
				<c:choose>
					<c:when test="${loginUser ne null }">
						<a class="nav-link px-3" href="/mypage">${loginUser.mi_name } 님</a>
						<a class="nav-link px-3" href="/logout">logout</a>
					</c:when>
					<c:otherwise>
						<a class="nav-link px-3" href="/signin">Sign in</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</header>

	<div class="container-fluid">
		<div class="row">
			<nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
				<div class="position-sticky pt-3">
					<ul class="nav flex-column">
						<li class="nav-item">
							<a class="nav-link active" aria-current="page" href="/"> 
								<span data-feather="home" class="align-text-bottom"></span> 
								Home
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/notice"> 
								<span data-feather="alert-circle" class="align-text-bottom"></span> 
								Notice
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/gallery"> 
								<span data-feather="instagram" class="align-text-bottom"></span>
								Gallery
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/mypage"> 
								<span data-feather="user" class="align-text-bottom"></span>
								My page
							</a>
						</li>					
					</ul>
				</div>
			</nav>
			<jsp:include page="${content }" />
			
		</div>
	</div>
  </body>
  <script src="/resources/js/dashboard.js"></script>
  <script type="text/javascript">
  	let msg = "${MSG }";
  	if(msg != ''){
	  	alert(msg);
  	}
  </script>
</html>
