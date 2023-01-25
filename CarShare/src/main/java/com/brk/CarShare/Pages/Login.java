package com.brk.CarShare.Pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Login {
    @GetMapping("/login/")
    public String GetIndex(){
        return "login/index.html";
    }
}

