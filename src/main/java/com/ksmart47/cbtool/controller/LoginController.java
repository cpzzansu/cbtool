package com.ksmart47.cbtool.controller;

import com.ksmart47.collaborationtool.dto.Member;
import com.ksmart47.collaborationtool.service.LoginService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Log4j2
@AllArgsConstructor
@Controller
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public String login(Model model, Member member){


        return "main/main";
    }

    @ResponseBody
    @PostMapping("/emailCheck")
    public String emailCheck(@RequestBody Member member){

        String result = loginService.emailCheck(member);

        return result;
    }

    @ResponseBody
    @PostMapping("/sendEmailCode")
    public String sendEmail(@RequestBody String to){

        String randomCode = loginService.sendEmail(to);

        return randomCode;
    }
}
