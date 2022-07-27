package com.spring.shop.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.shop.common.AttachDto;
import com.spring.shop.common.SearchDto.SearchRequest;

@Repository
public class NoticeRepositoryImpl implements NoticeRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<NoticeDto> selectListNotice(SearchRequest dto) {
		return sqlSession.getMapper(NoticeMapper.class).selectList(dto);
	}
	
	@Override
	public NoticeDto getLastestNotice() {
		return sqlSession.getMapper(NoticeMapper.class).getLastestNotice();
	}
	
	@Override
	public int getTotalCnt(SearchRequest dto) {
		return sqlSession.getMapper(NoticeMapper.class).getTotalCnt(dto);
	}
	
	@Override
	public int writeNotice(NoticeDto noticeDto) {
		return sqlSession.getMapper(NoticeMapper.class).write(noticeDto);
	}

	@Override
	public NoticeDto selectOneNotice(int nb_num) {
		return sqlSession.getMapper(NoticeMapper.class).selectOne(nb_num);
	}
	
	@Override
	public int editNotice(NoticeDto noticeDto) {
		return sqlSession.getMapper(NoticeMapper.class).edit(noticeDto);
	}
	
	@Override
	public int deleteNotice(int nb_num) {
		return sqlSession.getMapper(NoticeMapper.class).delete(nb_num);
	}
	
}
