<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4" id="notice_main">
	<div class="p-4 p-md-5 mb-4 text-white rounded bg-dark">
		<div class="col-md-6 px-0 lastest">
			<h1 class="display-4 fst-italic">Latest Notice : ${ lastestNotice.nb_subject }</h1>
			<p class="lead mb-0">${ lastestNotice.nb_content }</p>
			<p class="lead my-3">date : ${ lastestNotice.nb_createdAt }</p>
		</div>
	</div>
	
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<button type="button" class="btn btn-sm btn-outline-dark"
					onclick="location.href='/writeNoticeForm'">write Notice</button>
			</div>
			<div class="col-lg-8 col-md-9">
				<div class="search_box">
					<button type="button" class="input-group-append btn btn-dark searchBT">Search</button>	
				</div>	
				<div class="search_box">
					<input type="text" class="form-control searchText" aria-label="Text input with dropdown button">
				</div>			
				<div class="search_box">
				<select class="form-select" id="searchType" aria-label="Default select example" name="selectNotice">
					<option value="all">All</option>
					<option value="nb_subject">Subject</option>
					<option value="nb_id">ID</option>
				</select>
				</div>	
			</div>
		</div>	
	</div>

	<div class="table-responsive">
		<table class="table table-striped table-md">
			<thead>
				<tr>
					<th scope="col">No.</th>
					<th scope="col">Subject</th>
					<th scope="col">ID</th>
					<th scope="col">Date</th>
				</tr>
			</thead>
			<tbody class="list">

			</tbody>
		</table>	
	
		<div id="pageNav">
		</div>
	</div>
</main>
<script>
	$(document).ready(function() {
		getList(1);
		
		$(".searchBT").click(function(){
			getList(1);
		});
	});
	
	function getList(selPage) {
		let data = {};
		let searchType = $("#searchType option:selected").val();
		let keyword = $(".searchText").val();
		let pagePerCnt = 1;
		let curPage = selPage;
		
		data.searchType = searchType;
		data.keyword = keyword;
		data.pagePerCnt = pagePerCnt;
		data.curPage = curPage;
		
		$.ajax({
			type : 'GET',
			url : "/getNoticeList",
			data : data,
			error : function(error) {
				alert("Error!");
			},
			success : function(value) {
				$(".list").children().remove();
				
				console.log(value);
				let lastest = '';
				let html = '';
				let list  = '';
				for (let i = 0; i < value.searchData.list.length; i++) {
					list = value.searchData.list[i];
					html += '<tr>';
					html += '<td>' + list.nb_num
							+ '</td>';
					html += '<td><a href="/selectOneNotice/'+ list.nb_num +'">'
							+ list.nb_subject
							+ '</a></td>';
					html += '<td>' + list.nb_id
							+ '</td>';
					html += '<td>'
							+ list.nb_createdAt
							+ '</td>';
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
