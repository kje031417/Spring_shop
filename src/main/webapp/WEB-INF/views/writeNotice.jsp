<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
	<div class="input-form-backgroud row">
		<div class="input-form col-md-12 mx-auto">
			<h4 class="mb-3">Write notice</h4>
			<form class="validation-form" action="/writeNotice" method="post" enctype="multipart/form-data" novalidate>
				<div class="col-bg-6 mb-3">
					<label for="nb_subject">제목</label> 
					<input type="text" class="form-control" id="nb_subject" name="nb_subject" required>
					<div class="invalid-feedback">제목을 입력해주세요.</div>
				</div>
				
				<div class="col-bg-6 mb-3">
					<label for="nb_content">내용</label>
					<textarea class="form-control notice_ta" id="nb_content" name="nb_content" rows="10"></textarea>
					<div class="invalid-feedback">내용을 입력해주세요.</div>
				</div>
				<input type="hidden" id="nb_id" name="nb_id" value="${loginUser.mi_id }">
				<input type="file" name="file">
				<hr>
				<button class="btn btn-primary btn-lg btn-block" type="submit">Done</button>
			</form>
		</div>
	</div>
</main>