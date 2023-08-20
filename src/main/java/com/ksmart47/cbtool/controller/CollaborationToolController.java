package com.ksmart47.cbtool.controller;

import com.ksmart47.cbtool.dto.Brainstorming;
import com.ksmart47.cbtool.dto.BrainstormingOrder;
import com.ksmart47.cbtool.dto.Member;
import com.ksmart47.cbtool.service.BrainstormingService;
import com.ksmart47.cbtool.service.LoginService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@AllArgsConstructor
@Controller
public class CollaborationToolController {

    private final BrainstormingService brainstormingService;
    private final LoginService loginService;


    @GetMapping("/collaborationTool/collaborationTool")
    public String moveCollaborationTool(Model model, HttpSession session){
        Object S_LEVEL = session.getAttribute("S_LEVEL");
        if(S_LEVEL == null) return "redirect:/";
        int SLEVEL = (int) S_LEVEL;
        if(SLEVEL != 1) return "redirect:/";


        List<BrainstormingOrder> brainstormingOrderList = brainstormingService.getOrder();

        List<String> htmlList = new ArrayList<>();

        for(BrainstormingOrder brainstormingOrder : brainstormingOrderList){
            String id = brainstormingOrder.getOrderEleId();
            Brainstorming brainstorming = brainstormingService.getBrainStormingById(id);
            String htmlContent = brainstorming.getHtmlContent();
            htmlList.add(htmlContent);
        }

        model.addAttribute("title", "브레인스토밍");
        model.addAttribute("htmlList", htmlList);
        model.addAttribute("orderList", brainstormingOrderList);

        return "collaboration_tool/collaboration_tool";
    }

    @GetMapping("/collaborationTool/memberApplicationList")
    public String moveApplicationList(Model model, HttpSession session){
        Object S_LEVEL = session.getAttribute("S_LEVEL");
        if(S_LEVEL == null) return "redirect:/";
        int SLEVEL = (int) S_LEVEL;
        if(SLEVEL != 1) return "redirect:/";

        List<Member> memberList = loginService.applicationList();

        model.addAttribute("title","회원가입 신청목록");
        model.addAttribute("applicationList", memberList);

        return "collaboration_tool/member_application_list";
    }

    @GetMapping("/collaborationTool/levelUpgrade")
    public String levelUpgrade(@RequestParam String memberEmail){

        System.out.println(memberEmail);

        loginService.levelUpdate(memberEmail);

        return "redirect:/collaborationTool/memberApplicationList";
    }


}
