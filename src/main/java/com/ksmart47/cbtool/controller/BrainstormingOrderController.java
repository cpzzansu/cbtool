package com.ksmart47.cbtool.controller;

import com.ksmart47.cbtool.dto.BrainstormingOrder;
import com.ksmart47.cbtool.service.BrainstormingService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Log4j2
@AllArgsConstructor
@Controller
public class BrainstormingOrderController {

    private final BrainstormingService brainstormingService;

    @ResponseBody
    @PostMapping("/collaborationTool/changeOrder")
    public void changeOrder(@RequestBody ChangeOrderData changeOrderData){
        List<BrainstormingOrder> addList = changeOrderData.getOrderAddDataArr();
        List<BrainstormingOrder> modifyList = changeOrderData.getOrderModifyDataArr();
        if(addList != null){
            brainstormingService.addBrainstormingOrder(addList);
        } else if (modifyList != null) {
            brainstormingService.modifyBrainstormingOrder(modifyList);
        }
    }

    @Data
    class ChangeOrderData{
        private final List<BrainstormingOrder> orderAddDataArr;
        private final List<BrainstormingOrder> orderModifyDataArr;
    }
}
