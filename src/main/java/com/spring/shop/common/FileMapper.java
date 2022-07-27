package com.spring.shop.common;

import java.util.List;

public interface FileMapper {
	int insertFile(AttachDto attachDto);
	AttachDto selectFileName(RequestDto requestDto);
	List<AttachDto> selectFilesName(RequestDto requestDto);
	int editFile(AttachDto attachDto);
	int deleteFile(RequestDto requestDto);
}
