package com.spring.shop.login;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepositoryImpl implements MemberRepository{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int registryMember(MemberDto memberDto) {
		return sqlSession.getMapper(MemberMapper.class).registry(memberDto);
	}

	@Override
	public LoginDto loginMember(MemberDto memberDto) {
		return sqlSession.getMapper(MemberMapper.class).login(memberDto);
	}
	
	@Override
	public int editMember(MemberDto memberDto) {
		return sqlSession.getMapper(MemberMapper.class).edit(memberDto);
	}
	
	@Override
	public int withdrawMember(LoginDto loginDto) {
		return sqlSession.getMapper(MemberMapper.class).withdraw(loginDto);
	}
}
