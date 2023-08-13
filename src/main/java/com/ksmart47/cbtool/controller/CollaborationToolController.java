package com.ksmart47.cbtool.controller;

import com.ksmart47.cbtool.dto.Brainstorming;
import com.ksmart47.cbtool.service.BrainstormingService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@AllArgsConstructor
@Controller
public class CollaborationToolController {

    private final BrainstormingService brainstormingService;

    @GetMapping("/collaborationTool/collaborationTool")
    public String moveCollaborationTool(Model model){

        Brainstorming brainstorming = brainstormingService.getBrainStorming();

        String htmlContent = brainstorming.getHtmlContent();

        model.addAttribute("html", htmlContent);

        return "collaboration_tool/collaboration_tool";
    }
}
