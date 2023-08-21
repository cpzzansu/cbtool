package com.ksmart47.cbtool.dto;

import lombok.Data;

@Data
public class Member {

    private String memberEmail;
    private String memberPw;
    private String memberName;
    private String memberPhone;
    private int memberLevel;
}
