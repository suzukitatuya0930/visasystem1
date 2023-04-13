package com.example.demo.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserUpdateMapper;
import com.example.demo.model.UserUpdateModel;
import com.example.demo.service.UserUpdateService;
@Service
public class UserUpdateImpl implements UserUpdateService {
	 @Resource
	  UserUpdateMapper mapper;
	 
	

	public int update1(UserUpdateModel id) {
			
			return mapper.update1(id);
		
	}
    public List<UserUpdateModel>  checkall(UserUpdateModel newUser) {
		
		return mapper.checkall(newUser);
	}
	public List<UserUpdateModel> userupdate(int id){
    	
		return mapper.userupdate(id);
	}
public List<UserUpdateModel> selectusername(String email){
    	
		return mapper.selectusername(email);
	}

   

	}
	