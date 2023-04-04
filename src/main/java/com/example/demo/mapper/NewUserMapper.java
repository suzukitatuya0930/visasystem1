package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.NewUserModel;

@Repository
@Mapper
public interface NewUserMapper {
	int insert(NewUserModel newUser);
	int search(NewUserModel newUser);

}
