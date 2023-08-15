package com.ksmart47.cbtool.controller;

import com.ksmart47.cbtool.dto.Brainstorming;
import com.ksmart47.cbtool.dto.BrainstormingOrder;
import com.ksmart47.cbtool.service.BrainstormingService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@AllArgsConstructor
@Controller
public class CollaborationToolController {

    private final BrainstormingService brainstormingService;

    @GetMapping("/collaborationTool/collaborationTool")
    public String moveCollaborationTool(Model model){

        List<BrainstormingOrder> brainstormingOrderList = brainstormingService.getOrder();

        List<String> htmlList = new ArrayList<>();

        for(BrainstormingOrder brainstormingOrder : brainstormingOrderList){
            String id = brainstormingOrder.getOrderEleId();
            Brainstorming brainstorming = brainstormingService.getBrainStormingById(id);
            String htmlContent = brainstorming.getHtmlContent();
            htmlList.add(htmlContent);
        }

        model.addAttribute("htmlList", htmlList);
        model.addAttribute("orderList", brainstormingOrderList);

        return "collaboration_tool/collaboration_tool";
    }
}
