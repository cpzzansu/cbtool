package com.ksmart47.cbtool.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class CollaborationToolService {

    private final BrainstormingMapper brainstormingMapper;

    public void changeHtml(String clientMessage) throws JsonProcessingException {

        // JSON 문자열을 MyDTO 객체로 변환
        ObjectMapper objectMapper = new ObjectMapper();
        Brainstorming brainstorming = objectMapper.readValue(clientMessage, Brainstorming.class);

        String id = brainstorming.getId();
        Brainstorming idInfo = brainstormingMapper.checkId(id);

        if(idInfo == null){
            brainstormingMapper.addBrainstorming(brainstorming);
        } else {
            brainstormingMapper.modifyBrainstorming(brainstorming);
        }

    }
}
