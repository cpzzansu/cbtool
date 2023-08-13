package com.ksmart47.cbtool.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@AllArgsConstructor
@Controller
public class CollaborationToolController {

    @GetMapping("/collaborationTool/collaborationTool")
    public String moveCollaborationTool(Model model){


        return "collaboration_tool/collaboration_tool";
    }
}
