package org.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.JPA.dao.UserDao;
import org.example.JPA.entity.UserEntity;
import org.example.model.request.SignUpModel;
import org.example.model.response.UserListModel;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserDao userDao;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/signup", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void signUpAUser(@RequestBody SignUpModel model) throws JsonProcessingException {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(model.getUsername());
        userEntity.setPassword(model.getPassword());
        userEntity.setName(model.getName());
        userDao.save(userEntity);
    }

    @GetMapping(value = "userlist", produces = MediaType.APPLICATION_JSON_VALUE)
    public String userList() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper(); //TODO這東西賊耗能的應該做成一個單例:(

        UserListModel userListModel = new UserListModel();

        ArrayList<UserListModel.user> userList = new ArrayList<>();

        List<UserEntity> userEntities = userDao.findAll();
        userEntities.forEach(node -> {
            UserListModel.user user = new UserListModel.user();
            user.setUsername(node.getUsername());
            user.setName(node.getName());
            userList.add(user);
        });
        userListModel.setUserList(userList);
        return objectMapper.writeValueAsString(userListModel);
    }

    @RequestMapping("searchuser")
    public Object searchUser(@RequestParam String keyword){
        return userService.findByUsernameEndsWith(keyword);
    }

    //@PutMapping

    @RequestMapping("JPQLTest")
    public Object JPQLTest(@RequestParam int len){
        return userService.findByJPQL(len);
    }

}
