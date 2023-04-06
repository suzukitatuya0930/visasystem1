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
	
}
