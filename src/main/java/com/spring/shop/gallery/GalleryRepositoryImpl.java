package com.spring.shop.gallery;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.shop.common.SearchDto.SearchRequest;


@Repository
public class GalleryRepositoryImpl implements GalleryRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<MainGalleryDto> getMainImgList(SearchRequest dto) {
		return sqlSession.getMapper(GalleryMapper.class).getMainImgList(dto);
	}
	
	@Override
	public int getTotalCnt(SearchRequest dto) {
		return sqlSession.getMapper(GalleryMapper.class).getTotalCnt(dto);
	}

	@Override
	public GalleryDto getGalleryList(int gb_num) {
		return sqlSession.getMapper(GalleryMapper.class).getGalleryList(gb_num);
	}
	
	@Override
	public int uploadGallery(GalleryDto galleryDto) {
		return sqlSession.getMapper(GalleryMapper.class).uploadGallery(galleryDto);
	}
	
	@Override
	public int editGallery(GalleryDto galleryDto) {
		return sqlSession.getMapper(GalleryMapper.class).editGallery(galleryDto);
	}
	
	@Override
	public int deleteGallery(int gb_num) {
		return sqlSession.getMapper(GalleryMapper.class).deleteGallery(gb_num);
	}
}
