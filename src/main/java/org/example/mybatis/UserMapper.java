package org.example.mybatis;
import org.apache.ibatis.annotations.Mapper;
import org.example.mybatis.vo.User;

import java.util.List;

@Mapper
public interface UserMapper {

	List<User> getAll();
	
	// User getOne(Long id);

	// void insert(User user);

	// void update(User user);

	// void delete(Long id);

}