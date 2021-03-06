package com.itcs6112.oas.controller;

import java.util.Map;

import com.itcs6112.oas.model.UserInfo;
import com.itcs6112.oas.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;


@Controller 
@RequestMapping(path = "/users") 
public class UserInfoController {
    
    @Autowired 
    private UserInfoService userInfoService;
    
    @GetMapping(path = "/search")
    public @ResponseBody UserInfo searchForUser(@RequestBody Map<String, Object> request_body) {
        return userInfoService.findByEmail((String)request_body.get("email"));
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<UserInfo> retrieveAllUsers(){
        return userInfoService.getAllUsers();
    }
 


}