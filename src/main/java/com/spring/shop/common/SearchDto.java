package com.spring.shop.common;

import java.util.List;

import com.spring.shop.gallery.MainGalleryDto;
import com.spring.shop.notice.NoticeDto;

public class SearchDto {
	
	public static class SearchRequest {
		private String searchType;
		private String keyword;
		private int curPage;
		private int pagePerCnt;
		private int limit;
		private int offset;
		
		public SearchRequest() {
			// TODO Auto-generated constructor stub
		}

		public String getSearchType() {
			return searchType;
		}

		public void setSearchType(String searchType) {
			this.searchType = searchType;
		}

		public String getKeyword() {
			return keyword;
		}

		public void setKeyword(String keyword) {
			this.keyword = keyword;
		}

		public int getCurPage() {
			return curPage;
		}

		public void setCurPage(int curPage) {
			this.curPage = curPage;
		}

		public int getPagePerCnt() {
			return pagePerCnt;
		}

		public void setPagePerCnt(int pagePerCnt) {
			this.pagePerCnt = pagePerCnt;
		}

		public int getLimit() {
			return limit;
		}

		public void setLimit(int limit) {
			this.limit = limit;
		}

		public int getOffset() {
			return offset;
		}

		public void setOffset(int offset) {
			this.offset = offset;
		}

		public SearchRequest(String searchType, String keyword, int curPage, int pagePerCnt, int limit, int offset) {
			super();
			this.searchType = searchType;
			this.keyword = keyword;
			this.curPage = curPage;
			this.pagePerCnt = pagePerCnt;
			this.limit = limit;
			this.offset = offset;
		}
		
		public void generatePagenation(int limit, int offset) {
			this.limit = limit;
			this.offset = offset;
		}
	}

	public static class SearchCreateResponse {
		private SearchData searchData;
		
		public SearchCreateResponse() {
			// TODO Auto-generated constructor stub
		}

		public SearchData getSearchData() {
			return searchData;
		}

		public void setSearchData(SearchData searchData) {
			this.searchData = searchData;
		}

		public SearchCreateResponse(SearchData searchData) {
			super();
			this.searchData = searchData;
		}
	}
	
	public static class SearchData {
		private int totalCnt;
		private List<NoticeDto> list;
		
		public static SearchData create(int totalCnt, List<NoticeDto> list) {
			return new SearchData(totalCnt, list);
		}
		
		public SearchData() {
			// TODO Auto-generated constructor stub
		}

		public int getTotalCnt() {
			return totalCnt;
		}

		public void setTotalCnt(int totalCnt) {
			this.totalCnt = totalCnt;
		}

		public List<NoticeDto> getList() {
			return list;
		}

		public void setList(List<NoticeDto> list) {
			this.list = list;
		}

		public SearchData(int totalCnt, List<NoticeDto> list) {
			super();
			this.totalCnt = totalCnt;
			this.list = list;
		}
	}

	public static class GallerySearchCreateResponse {
		private GallerySearchData searchData;

		public GallerySearchCreateResponse() {
			// TODO Auto-generated constructor stub
		}

		public GallerySearchData getSearchData() {
			return searchData;
		}

		public void setSearchData(GallerySearchData searchData) {
			this.searchData = searchData;
		}
		
		public GallerySearchCreateResponse(GallerySearchData searchData) {
			super();
			this.searchData = searchData;
		}
	}
	
	public static class GallerySearchData {
		private int totalCnt;
		private List<MainGalleryDto> list;
		
		public static GallerySearchData create(int totalCnt, List<MainGalleryDto> list) {
			return new GallerySearchData(totalCnt, list);
		}
		
		public int getTotalCnt() {
			return totalCnt;
		}
		public void setTotalCnt(int totalCnt) {
			this.totalCnt = totalCnt;
		}
		public List<MainGalleryDto> getList() {
			return list;
		}
		public void setList(List<MainGalleryDto> list) {
			this.list = list;
		}
		
		public GallerySearchData() {
			// TODO Auto-generated constructor stub
		}
		
		public GallerySearchData(int totalCnt, List<MainGalleryDto> list) {
			super();
			this.totalCnt = totalCnt;
			this.list = list;
		}
	}
}
