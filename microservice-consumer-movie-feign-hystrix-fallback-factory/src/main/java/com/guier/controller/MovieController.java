package com.guier.controller;

import com.guier.dao.User;
import com.guier.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/movies")
@RestController
public class MovieController {

    @Autowired
    private UserFeignClient userFeignClient;

//    @Autowired
//    private FeignMsgClient feignMsgClient;

    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id) {
//        System.out.println(feignMsgClient.findById(id));
        return this.userFeignClient.findById(id);
    }
}
