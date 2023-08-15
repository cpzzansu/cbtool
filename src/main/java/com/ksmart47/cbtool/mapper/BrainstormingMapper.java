package com.ksmart47.cbtool.mapper;

import com.ksmart47.cbtool.dto.Brainstorming;
import com.ksmart47.cbtool.dto.BrainstormingOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BrainstormingMapper {

    public Brainstorming getBrainStormingById(String id);

    public Brainstorming checkId(String id);

    public void addBrainstorming(Brainstorming brainstorming);

    public void modifyBrainstorming(Brainstorming brainstorming);

    public List<BrainstormingOrder> getOrder();

    public void addBrainstormingOrder(List<BrainstormingOrder> addOrderList);

    public void modifyBrainstormingOrder(List<BrainstormingOrder> modifyOrderList);


}
