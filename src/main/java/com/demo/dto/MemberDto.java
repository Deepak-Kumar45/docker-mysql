package com.demo.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberDto {
    private String memberId;
    private String memberName;
    private String memberMail;
    private String password;
    private Date createdAt;
    private Date updatedAt;
}
