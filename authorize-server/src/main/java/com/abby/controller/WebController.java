package com.abby.controller;

import com.abby.mapper.User;
import com.abby.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class WebController {

    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello,this is the public resource";
    }

    @Resource
    public UserMapper userMapper;

    @RequestMapping(value = "/admin")
    public String admin(){
        User user=userMapper.selectByPrimaryKey(1);
        return "the admin is "+user.getUsername();
    }
}
