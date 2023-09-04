package org.example.model.request;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class SignUpModel {
    String username;
    String password;
    String name;

}
