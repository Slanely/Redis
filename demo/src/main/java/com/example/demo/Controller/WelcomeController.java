package com.example.demo.Controller;

import com.example.demo.ApplicationTests;
import com.example.demo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

@RestController
public class WelcomeController {
    @Autowired
    private RedisTemplate redisTemplate;
    @RequestMapping(value = "/string",method = RequestMethod.GET)
    public String welcome()
    {
        String temp = "This is a test case";
        redisTemplate.opsForValue().set("user_1",temp);
        return (String)redisTemplate.opsForValue().get("user_1");
    }
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public User welcomem()
    {
        User user = new User();
        user.setName("Slanely");
        user.setId(10086);
        redisTemplate.opsForValue().set("user_1",user);
        return (User)redisTemplate.opsForValue().get("user_1");
    }
}
