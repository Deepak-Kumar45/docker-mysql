package com.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.dto.MemberDto;
import com.demo.entity.Member;
import com.demo.repository.MemberRepo;
import com.demo.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MemberRepo memberRepo;

    @Override
    public Member addMember(MemberDto memberDto) {
        Member member = new Member();
        member.setMemberId(UUID.randomUUID().toString());
        member.setMemberName(memberDto.getMemberName());
        member.setMemberMail(memberDto.getMemberMail());
        member.setPassword(passwordEncoder.encode(memberDto.getPassword()));
        return memberRepo.save(member);
    }

    @Override
    public Optional<Member> getMemberById(String id) {
        return memberRepo.findById(id);
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepo.findAll();
    }

}
