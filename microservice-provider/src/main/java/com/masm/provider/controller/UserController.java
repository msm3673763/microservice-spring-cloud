package com.masm.provider.controller;

import com.masm.provider.entity.User;
import com.masm.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by simple on 2017/5/29.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable int id) {
        System.out.println("************************consumer call*****************************");
        return userService.findById(id);
    }

}
