package com.masm.consumer.controller;

import com.masm.consumer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by simple on 2017/5/29.
 */
@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${user.path}")
    private String path;

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable int id) {
        return restTemplate.getForObject(path + id, User.class);
    }

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable int id) {
        return restTemplate.getForObject("http://localhost:7900/findById/" + id, User.class);
    }
}
