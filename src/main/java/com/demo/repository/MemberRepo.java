package com.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Member;

@Repository
public interface MemberRepo extends JpaRepository<Member, String> {
    public Optional<Member> findByMemberMail(String memberMail);
}
