package com.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    @GetMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    @GetMapping("/processFormV2")
    public String upperCaseProcessForm(HttpServletRequest request, Model model){
        String name = request.getParameter("studentName");

        String result = "Yo! " + name.toUpperCase();

        model.addAttribute("message", result);

        return "helloworld";
    }

    @PostMapping("/processFormV3")
    public String upperCaseProcessForm(@RequestParam("studentName") String name, Model model){
        String result = "Hey My Friend from V3 " + name.toUpperCase();

        model.addAttribute("message", result);

        return "helloworld";
    }
}
