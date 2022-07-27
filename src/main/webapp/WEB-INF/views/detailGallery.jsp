<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<main class="ms-sm-auto col-lg-10 px-md-4">
	<div class="input-form-background row" style="display: inline-block;">
		<div class=" col-md-12 mx-auto">
			<h4 class="mb-3">Gallery no.${galleryDto.gb_num }</h4>
			<div class="col-bg-6 mb-3">
				<label>Subject : ${galleryDto.gb_subject }</label><br>	
				<label>ID : ${galleryDto.gb_id }</label>
			</div>
			
			<table>
				<tr>
					<c:forEach var="attachDto" items="${imgList }" varStatus="status">
						<c:if test="${status.index%2 == 0 }">
							</tr><tr>
						</c:if>
						<td style="padding: 7px;">						
							<img src="/resources/file/${attachDto.saved_file_name }" width="350px" height="350px" class="rounded mx-auto d-block">			
						</td>
					</c:forEach>
				</tr>
			</table>

			<label>첨부파일 : 	
				<c:choose>
					<c:when test="${imgList ne null }">
						<c:forEach var="attachDto" items="${imgList }">${attachDto.file_name }&nbsp;</c:forEach>
					</c:when>
					<c:otherwise>없음</c:otherwise>
				</c:choose>		
			</label>
			<hr>
				
			<button class="btn btn-primary btn-sm btn-block" type="button" onclick="location.href='/editGalleryForm/${galleryDto.gb_num}'">Edit</button>
			<button class="btn btn-primary btn-sm btn-block" type="button" onclick="location.href='/deleteGallery/${galleryDto.gb_num}'">Delete</button>
		</div>
	</div>
</main>