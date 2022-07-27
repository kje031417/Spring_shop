package com.spring.shop.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FileRepositoryImpl implements FileRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertFile(AttachDto attachDto) {
		return sqlSession.getMapper(FileMapper.class).insertFile(attachDto);
	}

	@Override
	public AttachDto selectFileName(RequestDto requestDto) {
		return sqlSession.getMapper(FileMapper.class).selectFileName(requestDto);
	}

	@Override
	public List<AttachDto> selectFilesName(RequestDto requestDto) {
		return sqlSession.getMapper(FileMapper.class).selectFilesName(requestDto);
	}
	
	@Override
	public int editFile(AttachDto attachDto) {
		return sqlSession.getMapper(FileMapper.class).editFile(attachDto);
	}

	@Override
	public int deleteFile(RequestDto requestDto) {
		return sqlSession.getMapper(FileMapper.class).deleteFile(requestDto);
	}
	
}
