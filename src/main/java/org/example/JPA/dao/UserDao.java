package org.example.JPA.dao;

import java.util.List;

import org.example.JPA.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<UserEntity,String> {
    List<UserEntity> findByUsernameEndsWith(String keyword);
    List<UserEntity> findByUsernameContains(String keyword);

    @Query("select u from UserEntity u where length(u.username) > ?1")
    List<UserEntity> findByJPQL(int len);
}
