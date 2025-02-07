package com.demo.service;

import java.util.List;
import java.util.Optional;

import com.demo.dto.MemberDto;
import com.demo.entity.Member;

public interface MemberService {

    public Member addMember(MemberDto memberDto);

    public Optional<Member> getMemberById(String id);

    public List<Member> getAllMembers();
}
