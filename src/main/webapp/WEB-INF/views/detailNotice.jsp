<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
	<div class="input-form-backgroud row">
		<div class="input-form col-md-12 mx-auto">
			<h4 class="mb-3">Notice no.${noticeDto.nb_num }</h4>
			<div class="col-bg-6 mb-3">
				<label>Subject : ${noticeDto.nb_subject }</label><br>	
			</div>

			<div class="col-bg-6 mb-3">
				<label>Content</label>
				<p class="lead mb-0">${noticeDto.nb_content }</p>
			</div>
			<label>첨부파일 : 
				<c:choose>
					<c:when test="${attachDto.file_name ne null }">${attachDto.file_name }</c:when> 
					<c:otherwise>없음</c:otherwise>
				</c:choose>
			</label>
			<hr>
				
			<button class="btn btn-primary btn-sm btn-block" type="button" onclick="location.href='/editNoticeForm/${noticeDto.nb_num}'">Edit</button>
			<button class="btn btn-primary btn-sm btn-block" type="button" onclick="location.href='/deleteNotice/${noticeDto.nb_num}'">Delete</button>
		</div>
	</div>
</main>