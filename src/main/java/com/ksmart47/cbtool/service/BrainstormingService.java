package com.ksmart47.cbtool.service;

import com.ksmart47.cbtool.dto.Brainstorming;
import com.ksmart47.cbtool.mapper.BrainstormingMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Log4j2
@Transactional
@Service
public class BrainstormingService {

    private final BrainstormingMapper brainstormingMapper;

    public Brainstorming getBrainStorming(){

        Brainstorming brainstorming = brainstormingMapper.getBrainstorming();

        return brainstorming;
    }
}
