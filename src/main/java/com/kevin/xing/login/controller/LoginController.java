package com.kevin.xing.login.controller;

import com.kevin.xing.login.model.User;
import com.kevin.xing.login.service.UserService;
import com.kevin.xing.result.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Resource
    private UserService userService;

//    @CrossOrigin
    @RequestMapping(value = "/checkInfo")
    @ResponseBody
    public Result checkInfo(@RequestBody User requestUser, HttpSession session) {
        // String username, @RequestParam String password
        String username = HtmlUtils.htmlEscape(requestUser.getUsername());

        User user = userService.findUserByUsernameAndPassword(username, requestUser.getPassword());

        if (user == null) {
            return new Result(false, "账户或密码错误");
        } else {
            session.setAttribute("user", user);
            return new Result(true, user);
        }
    }
}
