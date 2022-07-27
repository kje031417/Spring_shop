package com.spring.shop.login;

public interface MemberRepository {
	int registryMember(MemberDto memberDto);
	LoginDto loginMember(MemberDto memberDto);
	int editMember(MemberDto memberDto);
	int withdrawMember(LoginDto loginDto);
}
