package com.example.demo.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.NewUserMapper;
import com.example.demo.model.NewUserModel;
import com.example.demo.service.NewUserService;
@Service
public class NewUserImpl implements NewUserService {
	 @Resource
	 private NewUserMapper mapper;
	 

	public Object insert(NewUserModel newUser) {
		
		return mapper.insert(newUser);
	}
	
	
	public int search(NewUserModel newUser) {

        return mapper.search(newUser);
    }

	
	

	@Override
	public List<NewUserModel> user(NewUserModel newUserModel) {
		// TODO 自動生成されたメソッド・スタブ
		return mapper.user(newUserModel);
	}
	
	public int delete(NewUserModel newUser) {
		  
		  return mapper.delete(newUser);
		 }
		 public int update(NewUserModel newUser) {
		   
		   return mapper.update(newUser);
		  
		 }
		    public List<NewUserModel>  checkall(NewUserModel newUser) {
		  
		  return mapper.checkall(newUser);
		 }
		    public List<NewUserModel> selectupdate(NewUserModel newUser){
		     
		  return mapper.selectupdate(newUser);
		 }
	
	
}
