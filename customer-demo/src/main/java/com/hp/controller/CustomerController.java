package com.hp.controller;

import com.hp.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private RestTemplate template;

    @GetMapping("/{i}")
    public User getUser(@PathVariable("i") Long id){
        /**
         * 调用user-service的方法
         */
        User user = template.getForObject("http://localhost:8089/user/"+id,User.class);
        return user;
    }

}
