package com.kevin.xing.login.dao;

import com.kevin.xing.login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, String> {

    User findInfoByUsername(String username);

    User findInfoByUsernameAndPassword(String username, String password);
}
