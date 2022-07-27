<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
	<div class="input-form-backgroud row">
		<div class="input-form col-md-12 mx-auto">
			<h4 class="mb-3">Edit Gallery</h4>
			<form class="validation-form" action="/editGallery" method="post" enctype="multipart/form-data" novalidate>
				<div class="col-bg-6 mb-3">
					<label for="gb_subject">제목</label> 
					<input type="text" class="form-control" id="gb_subject" name="gb_subject" value="${galleryDto.gb_subject }" required>
					<div class="invalid-feedback">제목을 입력해주세요.</div>
				</div>
				
				<label>기존첨부파일 : 
					<c:forEach var="attachDto" items="${imgList }">${attachDto.file_name }&nbsp;</c:forEach>
				</label>
				<input type="hidden" id="gb_num" name="gb_num" value="${galleryDto.gb_num }">
				<input type="file" name="file" multiple="multiple">
				<hr>
				<button class="btn btn-primary btn-lg btn-block" type="submit">Edit</button>
			</form>
		</div>
	</div>
</main>