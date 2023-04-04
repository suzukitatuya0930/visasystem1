package com.example.demo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.NewUserModel;
import com.example.demo.service.NewUserService;



@Controller
@RequestMapping("/user")
public class MainController {
	
	@RequestMapping("/signup")
    public String signup() {
        return "signup";
        
    }
	
	
	@Resource
    private NewUserService newUserService;
	@PostMapping("/entry")
	public String entry(@Validated @ModelAttribute  NewUserModel newUserModel, BindingResult result,Model model){
		 int count =  newUserService.search(newUserModel);
		  if(count  == 0){
			 newUserService.insert(newUserModel);
	       model.addAttribute("name","登録完了");
	     
	       return "login";
			
		 }else {
			  
			 newUserService.search(newUserModel);
			model.addAttribute("id","別のログインIDを入力してください");
			  return "signup";
			
		 }
		  }
		  
		  
	

  


}