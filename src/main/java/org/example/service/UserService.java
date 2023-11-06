package org.example.service;

import java.util.List;

import org.example.JPA.dao.UserDao;
import org.example.JPA.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<UserEntity> findByUsernameEndsWith(String keyword){
        return userDao.findByUsernameEndsWith(keyword);
    }

    public List<UserEntity> findByJPQL(int len){
        return userDao.findByJPQL(len);
    }
    
}
