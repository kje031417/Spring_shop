<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
	<form id="signin_form" action="/login">
		<h1 class="h3 mb-3 fw-normal">Please sign in</h1>
		<div class="form-floating form_signin">
			<input type="text" class="form-control" id="mi_id" name="mi_id"> 
			<label for="mi_id">ID</label>
		</div>
		
		<div class="form-floating form_signin">
			<input type="password" class="form-control" id="mi_pw" name="mi_pw"> 
			<label for="mi_pw">Password</label>
		</div>

		<div class="checkbox mb-3">
			<label> 
				<input type="checkbox" value="remember-me">
				Remember me
			</label>
		</div>
		<button class="w-100 btn btn-lg btn-primary btn_signin" type="submit">Sign in</button>
		<button class="w-100 btn btn-lg btn-primary btn_signin" type="button" onclick="signup();">Sign up</button>
		<p class="mt-5 mb-3 text-muted">&copy; 2017–2022</p>
	</form>
</main>