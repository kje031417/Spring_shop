package com.spring.shop.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface FileService {
	AttachDto singleUpload(String path, MultipartHttpServletRequest mr, String board_type, int num) throws FileNotFoundException, IOException;
	List<AttachDto> multipleUpload(String path, MultipartHttpServletRequest mr, String board_type, int num) throws IOException;
}
