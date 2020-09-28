package com.project.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/main_page")
    public String getMainPage(){
        return "main_page";
    }
}
