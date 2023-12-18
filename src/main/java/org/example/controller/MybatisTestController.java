package org.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.example.model.response.UserListModel;
import org.example.mybatis.UserMapper;
import org.example.mybatis.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class MybatisTestController {
    @Autowired
    UserMapper userMapper;

    
    @GetMapping(value = "getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public String userList() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper(); //TODO這東西賊耗能的應該做成一個單例:(

        UserListModel userListModel = new UserListModel();

        ArrayList<UserListModel.user> userList = new ArrayList<>();

        List<User> userEntities = userMapper.getAll();
        userEntities.forEach(node -> {
            UserListModel.user user = new UserListModel.user();
            user.setUsername(node.getUsername());
            user.setName(node.getName());
            userList.add(user);
        });
        userListModel.setUserList(userList);
        return objectMapper.writeValueAsString(userListModel);
    }
}
