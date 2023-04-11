package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.NewUserModel;

@Repository
@Mapper
public interface NewUserMapper {
	int insert(NewUserModel newUser);
	int search(NewUserModel newUser);
	List<NewUserModel> user(NewUserModel newUserModel);
	
	int delete(NewUserModel newUser);
	 List<NewUserModel> checkall(NewUserModel newUserModel);
	 List<NewUserModel> selectupdate(NewUserModel newUserModel);
	 int update(NewUserModel newUser);
}
