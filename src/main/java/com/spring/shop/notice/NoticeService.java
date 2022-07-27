package com.spring.shop.notice;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.spring.shop.common.AttachDto;
import com.spring.shop.common.SearchDto.SearchData;
import com.spring.shop.common.SearchDto.SearchRequest;

public interface NoticeService {
	SearchData selectListNotice(SearchRequest dto);
	NoticeDto getLastestNotice();
	int getTotalCnt(SearchRequest dto);
	int writeNotice(NoticeDto noticeDto, HttpServletRequest req) throws IOException;
	NoticeDto selectOneNotice(int nb_num);
	AttachDto selectFileName(int nb_num);
	int editNotice(NoticeDto noticeDto, HttpServletRequest req) throws IOException;
	int deleteNotice(int nb_num, HttpServletRequest req);
}
