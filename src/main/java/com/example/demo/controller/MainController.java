package com.example.demo.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	//index.htmlで<a th:href="@{/user/signup}">で指定している
	@GetMapping("/signup")
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
	
	
	
	@Autowired
	private LoginUserService loginUserService;
	
	@PostMapping("/login")
	public String login(@ModelAttribute LoginUserModel loginUserModel, Model model) {
		 //idとパスワードが合っているか判断
		//間違ってた場合login画面へ合っていたら,マイページへ
		  int count =  (int)loginUserService.count(loginUserModel);
		  if(count  == 0 ) {
			  model.addAttribute("error","エラー");
			  
			  return "index";
		  }
		
		  else if(loginUserModel.getEmail().equals("admin@admin"))
		 
		 {
			 
			 
			 return "home";
			 
		}else {
			 
		 
			
			List<LoginUserModel> listuser=loginUserService.user(loginUserModel);
		       System.out.println(listuser);
		       model.addAttribute("listuser",listuser);
		       
		      
//			    // 今日の日付を取得する
			    LocalDate today = LocalDate.now();
			    
			    LocalDate dbDate = LocalDate.parse(listuser.get(0).getVisa());
			    //
			    // 日数の差分を計算する
			    long daysBetween = ChronoUnit.DAYS.between(today, dbDate);

			    // 結果をHTMLに表示する
			    model.addAttribute("daysBetween", daysBetween);
		      
			 return "mypage";
	}
		 
		
		    }
	
//  @GetMapping("/login")
//      public String user(Model model,LoginUserModel loginUserModel) {
//	  LocalDate dbDate = LocalDate.parse(loginUserModel.getVisa());
//
//	    // 今日の日付を取得する
//	    LocalDate today = LocalDate.now();
//
//	    // 日数の差分を計算する
//	    long daysBetween = ChronoUnit.DAYS.between(today, dbDate);
//
//	    // 結果をHTMLに表示する
//	    model.addAttribute("daysBetween", daysBetween);
//          return "mypage";
//      }
//		 		  
		  
	@GetMapping("/update")
	public String update() {
        return "update";
        }
	
	@PostMapping("/userupdate")
	public String userupdate() {
		
        return "mypage";
        }



		  

}
	


	


