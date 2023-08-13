package com.ksmart47.cbtool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(Model model, @RequestParam(value = "msg", required = false) String msg){

        model.addAttribute("title", "PCT login");

        if(msg != null) {
            model.addAttribute("msg", msg);
        }

        return "main/main";
    }
}
