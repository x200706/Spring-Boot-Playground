package org.example.model.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserListModel {
    List<user> userList = new ArrayList<>();

    @Data
    public static class user{
        String username;
        String name;
    }

}
