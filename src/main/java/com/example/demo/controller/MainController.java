package com.example.demo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.LoginUserModel;
import com.example.demo.model.NewUserModel;
import com.example.demo.service.LoginUserService;
import com.example.demo.service.NewUserService;

import lombok.extern.slf4j.Slf4j;



@Controller
@RequestMapping("/user")
@Slf4j

public class MainController {
	
	//ログイン画面から新規登録
	@RequestMapping("/signup")
    public String signup() {
        return "signup";
        }
	
//	
	@Resource
    private NewUserService newUserService;
	//新規登録画面
	@PostMapping("/entry")
	public String entry(@ModelAttribute NewUserModel newUserModel,Model model){
		//既に登録されているメールアドレスか判断 
		int count =  newUserService.search(newUserModel);
		  if(count  == 0){
			 newUserService.insert(newUserModel);
	       model.addAttribute("name","登録完了");
	       																																																																																																																																																																															
	       return "index";
			
		 }else {
			  
			 newUserService.search(newUserModel);
			model.addAttribute("id","既にメールアドレスが登録されています。");
			  return "signup";
			
		 }
		  }
	
	
	
	@Resource
	private LoginUserService loginUserService;
	@PostMapping("/login")
	public String login(@ModelAttribute LoginUserModel loginUserModel, Model model) {
		 //idとパスワードが合っているか判断
		//間違ってた場合login画面へ合っていたら,マイページへ
		  int count =  (int)loginUserService.count(loginUserModel);
		  if(count  == 0 ) {
			  model.addAttribute("error","エラー");
			  
			  return "index";
			  
		 }else {
			// String name = loginUserService.data(loginUserModel);
			 
			 return "mypage";//マイページ
		
	}
	
	
		  
		  
}
}


  


