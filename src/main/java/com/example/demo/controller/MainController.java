package com.example.demo.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.LoginUserModel;
import com.example.demo.model.NewUserModel;
import com.example.demo.model.UserUpdateModel;
import com.example.demo.service.LoginUserService;
import com.example.demo.service.NewUserService;
import com.example.demo.service.UserUpdateService;

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
	
	//ログイン画面に戻る
	@GetMapping("/backlogin")
	public String backlogin() {
		return"index";
	}
	

	@Resource
    private NewUserService newUserService;
	
	//新規登録画面ので処理
	@PostMapping("/entry")
	public String entry(@ModelAttribute NewUserModel newUserModel,Model model){
		//既に登録されているメールアドレスか判断 
		int count =  newUserService.search(newUserModel);
		  if(count  == 0){
			 newUserService.insert(newUserModel);
	       model.addAttribute("name","登録完了");
	       																																																																																																																																																																															
	       return "index";
			
		 }else {
			  
			 //既に登録されたメールアドレスが登録された場合
			 newUserService.search(newUserModel);
			model.addAttribute("id","既にメールアドレスが登録されています。");
			  return "signup";
			
		 }
		  }
	
	
	
	@Autowired
	private LoginUserService loginUserService;
	
	@PostMapping("/login")
	public String login(@ModelAttribute LoginUserModel loginUserModel, Model model,HttpSession session) {
		 //idとパスワードが合っているか判断
		//間違ってた場合login画面へ
		  int count =  (int)loginUserService.count(loginUserModel);
		  if(count  == 0 ) {
			  model.addAttribute("error","メールアドレス又はパスワードが正しくありません");
			  
			  return "index";
		  }
		  
		//admin@adminと入力された場合ユーザ一覧画面へ
		  else if(loginUserModel.getEmail().equals("admin@admin"))
		 
		 {
			  
			 return "redirect:/user/home";
			 
		}else {
			 
		 
			//メアドとパスワードが正しい場合マイページへ
			List<LoginUserModel> listuser=loginUserService.user(loginUserModel);
			  session.setAttribute("email", loginUserModel.getEmail());
		       
		       model.addAttribute("listuser",listuser);
		       
		       String email = (String) session.getAttribute("email");
		       System.out.println(email);
		       
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
	
	@GetMapping("/home")
    public String home(Model model,NewUserModel newUserModel) {
		//listでユーザの一覧を取得
     List<NewUserModel> listuser=newUserService.checkall(newUserModel);
     
     model.addAttribute("listuser",listuser);
     List<Long> daysBetweenList = new ArrayList<>();

     LocalDate today = LocalDate.now();

     for (NewUserModel user : listuser) {
         LocalDate dbDate = LocalDate.parse(user.getVisa());
         long daysBetween = ChronoUnit.DAYS.between(today, dbDate);
        // daysBetweenList.add(daysBetween);
         user.setRemaining(String.valueOf(daysBetween));
         System.out.println("Daysbetween today and"+ dbDate +"is"+ daysBetween);
     }
     model.addAttribute("daysBetweenList", daysBetweenList);

        return "home";
     
    }
	
//idを参照しデリート処理
	@GetMapping("/delete/{id}")
	   public String getdelete(@PathVariable("id") int id,Model model, NewUserModel newUserModel) {
	    List<NewUserModel> listuser=newUserService.selectupdate(newUserModel);
	     model.addAttribute("listuser",listuser);

	  return "delete";
	    }
	 @PostMapping("/delete/{id}")
	   public String delete(@PathVariable("id") int id, NewUserModel newUserModel) {
	  List<NewUserModel> listuser=newUserService.selectupdate(newUserModel);
	  System.out.println(listuser);
	  newUserService.delete(newUserModel);
	  
	  return "redirect:/user/home";
	 
	 }
  
	//idを参照しアップデート処理
	@GetMapping("/update/{id}")
	public String getupdateid(@PathVariable("id")  int id,Model model,NewUserModel newUserModel) {
		List<NewUserModel> listuser=newUserService.selectupdate(newUserModel);
		model.addAttribute("listuser",listuser);
		return "update";
 }
	
	@PostMapping("/update/{id}")
	public String update(NewUserModel newUserModel, Model model,BindingResult result){
		newUserService.update(newUserModel);
		System.out.println(newUserService.update(newUserModel));
		return "redirect:/user/home";
		
		
 }
	
	//検索処理
	@GetMapping("/search")
	 public String search(@RequestParam(value = "q", required = false) String query,
	                      @RequestParam(value = "type", required = false) String type,
	                      Model model) {
	     List<NewUserModel> listUser = new ArrayList<>();
	     //find pulldown
	     if (type != null && !type.trim().isEmpty()) {
	         listUser = newUserService.searchUser(type);
	     }
	     //find text
	     if (query != null && !query.trim().isEmpty()) {
	         listUser = newUserService.searchUser(query);
	     }
	   
	     model.addAttribute("listuser", listUser);

	     List<Long> daysBetweenList = new ArrayList<>();
	     LocalDate today = LocalDate.now();

	     for (NewUserModel user : listUser) {
	         LocalDate dbDate = LocalDate.parse(user.getVisa());
	         long daysBetween = ChronoUnit.DAYS.between(today, dbDate);
	         user.setRemaining(String.valueOf(daysBetween));
	         System.out.println("Days between today and " + dbDate + " is " + daysBetween);
	     }

	     model.addAttribute("daysBetweenList", daysBetweenList);

	     return "/home";
	 }

	
	
	@Autowired
	private UserUpdateService userUpdateService;
	
	
	@GetMapping("/update1/{id}")
	public String getupdatd(@PathVariable("id")int id,Model model) {
		System.out.println(id);
		List<UserUpdateModel> listuser= userUpdateService.userupdate(id); //chi hien thi hang so ...
		model.addAttribute("listuser",listuser);
		return "userupdate";
	}

	@PostMapping("/update1/{id}")
	public String update1(@PathVariable("id")int id,UserUpdateModel userUpdateModel, Model model){
		System.out.println(id);
		 userUpdateService.update1(userUpdateModel);
		 List<UserUpdateModel> listuser= userUpdateService.userupdate(id); 
			model.addAttribute("listuser",listuser);
			LocalDate today = LocalDate.now();
		    
		    LocalDate dbDate = LocalDate.parse(listuser.get(0).getVisa());
		    //
		    // 日数の差分を計算する
		    long daysBetween = ChronoUnit.DAYS.between(today, dbDate);

		    // 結果をHTMLに表示する
		    model.addAttribute("daysBetween", daysBetween);
		return "mypage";
		
		}

	@GetMapping("/mypage")
	public String mypage(Model model,HttpSession session) {
		String email = (String) session.getAttribute("email");
		System.out.println(email);
		List<UserUpdateModel> listuser = userUpdateService.selectusername(email);
		model.addAttribute("listuser", listuser);
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








	


	


