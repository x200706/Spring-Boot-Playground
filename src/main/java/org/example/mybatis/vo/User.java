package org.example.mybatis.vo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("User")
public class User{
    String username;
    String password;
    String name;
}