<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
	
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<button type="button" class="btn btn-md btn-outline-dark gallery-top"
						onclick="location.href='/uploadGalleryForm'">upload Image</button>
			</div>
			<div class="col-lg-8 col-md-9 gallery-top">
				<div class="search_box">
					<button type="button" class="input-group-append btn btn-dark searchBT">Search</button>	
				</div>	
				<div class="search_box">
					<input type="text" class="form-control searchText" aria-label="Text input with dropdown button">
				</div>			
				<div class="search_box">
					<select class="form-select" id="searchType" aria-label="Default select example" name="selectGallery">
						<option value="all">All</option>
						<option value="gb_subject">Subject</option>
						<option value="gb_id">ID</option>
					</select>
				</div>	
			</div>
		</div>
	</div>
	
	<div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center">
		<h2 class="display-5">Welcome to Gallery</h2>
		<div style="display: inline-block;">
			<table>
				<tbody class="list">
					
				</tbody>
			</table>
		</div>
		
		<div id="pageNav">
		</div>
	</div>
</main>

<script>
	$(document).ready(function() {
		getList(1);
		
		$(".searchBT").click(function() {
			getList(1);
		});
	});
	
	function getList(selPage) {
		let data = {};
		let searchType = $("#searchType option:selected").val();
		let keyword = $(".searchText").val();
		let pagePerCnt = 2;
		let curPage = selPage;
		
		data.searchType = searchType;
		data.keyword = keyword;
		data.pagePerCnt = pagePerCnt;
		data.curPage = curPage;
		
		$.ajax({
			type : "GET",
			url : "/getMainImgList",
			data : data, 
			error : function(error) {
				alert("error");
			},
			success : function(value){ 
				$(".list").children().remove();
				
				console.log(value);
				let html = '';
				let list = '';
				for(let i = 0; i < value.searchData.list.length; i++) {
					list = value.searchData.list[i];
					html += '<tr>';
					html += '<td class="imgTable">';
					html += '<a href="/selectOneGallery/' 
							+ list.gb_num + '">';
					if(list.saved_file_name != null) {
						html += '<img src="/resources/file/' 
							+ list.saved_file_name 
							+ '" width="500px" height="350px" class="rounded mx-auto d-block"/>';
					} else {
						html += '<img alt="" src="https://www.ecostartup.kr/src/images/noImg.gif">';
					}	
					html += '</a>';
					html += '</td>';	
					html += '</tr>';
				}
				
				$(".list").append(html);
				$("#pageNav").paging({
					pageSize: data.pagePerCnt,
					currentPage: data.curPage,
					pageTotal: value.searchData.totalCnt
				});
			}
		});
	}
	
	function goPage(selPage) {
		getList(selPage);
	}
</script>