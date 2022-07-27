package com.spring.shop.gallery;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.spring.shop.common.AttachDto;
import com.spring.shop.common.SearchDto.GallerySearchData;
import com.spring.shop.common.SearchDto.SearchRequest;

public interface GalleryService {
	GallerySearchData getMainImgList(SearchRequest dto);
	GalleryDto getGalleryList(int gb_num);
	List<AttachDto> getFilesPath(int gb_num);
	int uploadGallery(GalleryDto galleryDto, HttpServletRequest req) throws IOException;
	int editGallery(GalleryDto galleryDto, HttpServletRequest req);
	int deleteGallery(int gb_num, HttpServletRequest req);
}
