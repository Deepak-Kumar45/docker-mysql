package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.demo.dto.MemberDto;
import com.demo.entity.Member;
import com.demo.service.MemberService;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/member/add")
    private ResponseEntity<?> add(@RequestBody MemberDto memberDto) {
        System.err.println("Adding new member" + memberDto);
        Member member = memberService.addMember(memberDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(member);
    }

    @GetMapping("/member/")
    private ResponseEntity<?> getAllMembers() {
        List<Member> allMembers = memberService.getAllMembers();
        return ResponseEntity.status(HttpStatus.FOUND).body(allMembers);
    }

    @GetMapping("/member/{id}")
    private ResponseEntity<?> getMemebrById(@PathVariable("id") String id) {
        Member member = memberService.getMemberById(id).orElseThrow(() -> new RuntimeException("Member not found"));
        return ResponseEntity.status(HttpStatus.FOUND).body(member);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
