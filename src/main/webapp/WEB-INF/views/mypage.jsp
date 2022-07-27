<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
	<div class="input-form-backgroud row">
		<div class="input-form col-md-12 mx-auto">
			<h4 class="mb-3">Edit Form</h4>
			<form class="validation-form" action="/edit" method="post" novalidate>
				<div class="mb-3">
					<label for="mi_name">Name</label> 
					<input type="text" class="form-control" id="mi_name" name="mi_name" value="${loginUser.mi_name }" required>
					<div class="invalid-feedback">이름을 입력해주세요.</div>
				</div>
				<div class="row">
					<div class="col-md-6 mb-3">
						<label for="mi_id">ID</label> 
						<input type="text" class="form-control" id="mi_id" name="mi_id" value="${loginUser.mi_id }" readonly="readonly" required>
						<div class="invalid-feedback">아이디를 입력해주세요.</div>
					</div>
					<div class="col-md-6 mb-3">
						<label for="mi_pw">Password</label> 
						<input type="text" class="form-control" id="mi_pw" name="mi_pw" readonly="readonly" required>
						<div class="invalid-feedback">비밀번호를 입력해주세요.</div>
					</div>
				</div>

				<div class="mb-3">
					<label for="mi_email">Email</label> 
					<input type="email" class="form-control" id="mi_email" name="mi_email" value="${loginUser.mi_email }" required>
					<div class="invalid-feedback">이메일을 입력해주세요.</div>
				</div>
				
				<div class="row">
					<div class="col-md-6 mb-3">
						<label for="mi_mobile">Mobile</label>
						<input type="text" class="form-control" id="mi_mobile" name="mi_mobile" value="${loginUser.mi_mobile }" required>
					</div>
					<div class="col-md-6 mb-3">
						<label for="mi_tell">Tell <span class="text-muted">&nbsp;(not necessary)</span></label>
						<input type="text" class="form-control" id="mi_tell" name="mi_tell" value="${loginUser.mi_tell }">
					</div>
				</div>
				
				<label for="mi_postcode">PostCode</label>
				<div class="row">
					<div class="col-md-3 mb-3">					
						<input type="text" class="form-control" id="mi_postcode" name="mi_postcode" value="${loginUser.mi_postcode }" required>
					</div>
					<div class="col-md-6 mb-3">
						<button type="button" class="btn btn-primary" onclick="execDaumPostcode()">우편번호찾기</button>
					</div>
				</div>
				
				<div class="mb-3">
					<label for="mi_address">address</label> 
					<input type="text" class="form-control" id="mi_address" name="mi_address" value="${loginUser.mi_address }" required>
					<div class="invalid-feedback">도로명주소</div>
				</div>

				<div class="mb-3">
					<label for="mi_detailaddress">address2 <span class="text-muted">&nbsp;(not necessary)</span> </label> 
					<input type="text" class="form-control" id="mi_detailaddress" name="mi_detailaddress" value="${loginUser.mi_detailaddress }">
				</div>
				
				<div class="mb-3">
					<label for="mi_createdat">signup date <span class="text-muted">&nbsp;${loginUser.mi_createdat }</span> </label> 
				</div>
				
				<hr class="mb-4">
				
				<div class="row">
					<div class="col-md-6 mb-3">		
						<button class="btn btn-primary btn-lg btn-block" type="submit">Edit</button>
					</div>
					
					<div class="col-md-6 mb-3">		
						<button class="btn btn-primary btn-lg btn-block" type="button" onclick="location.href='/withdraw'">Withdraw</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<footer class="my-3 text-center text-small">
		<p class="mb-1">&copy; 2022</p>
	</footer>
</main>