package com.ksmart47.cbtool.controller;

import com.ksmart47.cbtool.dto.Member;
import com.ksmart47.cbtool.service.LoginService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Log4j2
@AllArgsConstructor
@Controller
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public String login(Model model, Member member, HttpSession session, RedirectAttributes reAttr){

        Map<String, Object> resultMap = loginService.login(member);
        boolean isValid = (boolean) resultMap.get("isValid");
        if(isValid){
            Member memberInfo = (Member) resultMap.get("member");

            String memberName = memberInfo.getMemberName();
            String memberEmail = memberInfo.getMemberEmail();
            session.setAttribute("S_EMAIL", memberEmail);
            session.setAttribute("S_NAME", memberName);
            model.addAttribute("title", "PCT main");

            return "redirect:/collaborationTool/collaborationTool";
        }

        String msg = (String) resultMap.get("msg");
        reAttr.addAttribute("msg", msg);

        return "redirect:/";
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
