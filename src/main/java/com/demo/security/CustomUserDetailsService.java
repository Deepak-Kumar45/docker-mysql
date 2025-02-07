package com.demo.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.entity.Member;
import com.demo.repository.MemberRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private MemberRepo memberRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> user = memberRepo.findByMemberMail(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        return user.get();
    }

}
