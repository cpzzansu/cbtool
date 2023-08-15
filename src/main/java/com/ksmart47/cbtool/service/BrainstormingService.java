package com.ksmart47.cbtool.service;

import com.ksmart47.cbtool.dto.Brainstorming;
import com.ksmart47.cbtool.dto.BrainstormingOrder;
import com.ksmart47.cbtool.mapper.BrainstormingMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Log4j2
@Transactional
@Service
public class BrainstormingService {

    private final BrainstormingMapper brainstormingMapper;

    public List<BrainstormingOrder> getOrder(){
        List<BrainstormingOrder> orderList = brainstormingMapper.getOrder();
        return orderList;
    }

    public Brainstorming getBrainStormingById(String id){

        Brainstorming brainstorming = brainstormingMapper.getBrainStormingById(id);

        return brainstorming;
    }

    public void addBrainstormingOrder(List<BrainstormingOrder> addOrderList){
        brainstormingMapper.addBrainstormingOrder(addOrderList);
    }
    public void modifyBrainstormingOrder(List<BrainstormingOrder> addOrderList){
        brainstormingMapper.modifyBrainstormingOrder(addOrderList);
    }
}
