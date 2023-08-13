package com.ksmart47.cbtool.mapper;

import com.ksmart47.collaborationtool.dto.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {

    public Member emailCheck(Member member);
}
