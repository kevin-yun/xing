package com.kevin.xing.login.controller;

import com.kevin.xing.result.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/checkInfo")

    public Result checkInfo(String username, String password) {


        return new Result(null);
    }
}
