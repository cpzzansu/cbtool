package com.ksmart47.cbtool.mapper;

import com.ksmart47.cbtool.dto.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoginMapper {

    public Member emailCheck(Member member);

    public void addMember(Member member);

    public List<Member> applicationList();

    public void levelUpdate(String memberEmail);

}
