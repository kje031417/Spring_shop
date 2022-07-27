package com.spring.shop.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public int registryMember(MemberDto memberDto) {
		// 서비스 로직을 하면댐
		return memberRepository.registryMember(memberDto);
	}
	
	@Override
	public LoginDto loginMember(MemberDto memberDto) {
		return memberRepository.loginMember(memberDto);
	}
	
	@Override
	public int editMember(MemberDto memberDto) {
		return memberRepository.editMember(memberDto);
	}
	
	@Override
	public int withdrawMember(LoginDto loginDto) {
		return memberRepository.withdrawMember(loginDto);
	}
}
