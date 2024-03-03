package com.springmvc.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/customLoginPage")
    public String showCustomLoginPage(){
        return "custom-login";
    }

    @GetMapping("/access-denied")
    public String showAccessDeniedPage(){
        return "access-denied";
    }
}
