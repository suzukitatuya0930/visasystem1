package com.example.demo.service;

import java.util.List;

import com.example.demo.model.UserUpdateModel;


public interface UserUpdateService {
	
	 public int update1(UserUpdateModel id);
	 public List<UserUpdateModel>userupdate(int id);
	 public List<UserUpdateModel>selectusername(String email);

}
