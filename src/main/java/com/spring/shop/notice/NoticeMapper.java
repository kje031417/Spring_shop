package com.spring.shop.notice;

import java.util.List;

import com.spring.shop.common.AttachDto;
import com.spring.shop.common.SearchDto.SearchRequest;

public interface NoticeMapper {
	List<NoticeDto> selectList(SearchRequest dto);
	NoticeDto getLastestNotice();
	int getTotalCnt(SearchRequest dto);
	int write(NoticeDto noticeDto);
	NoticeDto selectOne(int nb_num);
	int edit(NoticeDto noticeDto);
	int delete(int nb_num);
}
