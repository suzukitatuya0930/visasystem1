package com.example.demo.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.NewUserMapper;
import com.example.demo.model.NewUserModel;
import com.example.demo.service.NewUserService;
@Service
public class NewUserImpl implements NewUserService {
	 @Resource
	    private NewUserMapper mapper;
	@Override
	public Object insert(NewUserModel newUser) {
		// TODO 自動生成されたメソッド・スタブ
		return mapper.insert(newUer);
	}
	public int search(NewUserModel newUer) {

        return mapper.search(newUer);
    }
	
}
