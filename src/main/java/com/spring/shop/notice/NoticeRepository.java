package com.spring.shop.notice;

import java.util.List;

import com.spring.shop.common.AttachDto;
import com.spring.shop.common.SearchDto.SearchRequest;

public interface NoticeRepository {
	List<NoticeDto> selectListNotice(SearchRequest dto);
	NoticeDto getLastestNotice();
	int getTotalCnt(SearchRequest dto);
	int writeNotice(NoticeDto noticeDto);	
	NoticeDto selectOneNotice(int nb_num);	
	int editNotice(NoticeDto noticeDto);	
	int deleteNotice(int nb_num);	
}
