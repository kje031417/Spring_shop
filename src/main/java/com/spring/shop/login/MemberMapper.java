package com.spring.shop.login;

public interface MemberMapper {
	int registry(MemberDto memberDto);
	LoginDto login(MemberDto memberDto);
	int edit(MemberDto memberDto);
	int withdraw(LoginDto loginDto);
}
