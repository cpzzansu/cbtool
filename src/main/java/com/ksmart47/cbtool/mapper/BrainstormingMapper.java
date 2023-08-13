package com.ksmart47.cbtool.mapper;

import com.ksmart47.cbtool.dto.Brainstorming;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BrainstormingMapper {

    public Brainstorming getBrainstorming();
}
