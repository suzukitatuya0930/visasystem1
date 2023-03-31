package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class MainController {
	
	@RequestMapping("/signup")
    public String signup() {
        return "signup";
        
    }
	
	
  
}
