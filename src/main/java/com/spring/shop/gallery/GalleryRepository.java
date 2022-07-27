package com.spring.shop.gallery;

import java.util.List;

import com.spring.shop.common.SearchDto.SearchRequest;

public interface GalleryRepository {
	List<MainGalleryDto> getMainImgList(SearchRequest dto);
	int getTotalCnt(SearchRequest dto);
	GalleryDto getGalleryList(int gb_num);
	int uploadGallery(GalleryDto galleryDto);
	int editGallery(GalleryDto galleryDto);
	int deleteGallery(int gb_num);
}
