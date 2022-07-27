package com.spring.shop.common;

import org.springframework.stereotype.Component;

import com.spring.shop.common.SearchDto.SearchRequest;

@Component
public class PageGenerator {
	
	public SearchRequest generatePaging(SearchRequest dto) {
		
		int limit = ((dto.getCurPage() - 1) * dto.getPagePerCnt()) + dto.getPagePerCnt();
		int offset = (dto.getCurPage() - 1) * dto.getPagePerCnt();
		
		dto.generatePagenation(limit, offset);
		
		return dto;
	}
}
