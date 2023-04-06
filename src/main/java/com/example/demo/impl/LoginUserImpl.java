package com.example.demo.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.LoginUserMapper;
import com.example.demo.model.LoginUserModel;
import com.example.demo.service.LoginUserService;


@Service
public class LoginUserImpl implements LoginUserService {
	 @Resource
	    private LoginUserMapper mapper;

	@Override
	public int count(LoginUserModel loginUser) {
		
		return mapper.count(loginUser);
	}
	
	
	public List<LoginUserModel>getUser() {
		return mapper.getUser();
	}


	@Override
	public List<LoginUserModel> user(LoginUserModel loginUserModel) {
		// TODO 自動生成されたメソッド・スタブ
		return mapper.user(loginUserModel);
	}

}
