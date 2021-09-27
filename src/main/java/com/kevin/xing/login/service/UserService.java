package com.kevin.xing.login.service;

import com.kevin.xing.login.dao.UserDao;
import com.kevin.xing.login.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public User findUserByUsername(String username) {
        return userDao.findInfoByUsername(username);
    }

    public User findUserByUsernameAndPassword(String username, String password) {
        return userDao.findInfoByUsernameAndPassword(username, password);
    }

    public void addUser(User user) {
        userDao.save(user);
    }
}
