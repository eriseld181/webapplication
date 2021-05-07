package com.crystal.webapplication.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class HomeController {
    @Value("1.0.2")
    private String appVersion;
    @GetMapping
    @RequestMapping("/")
    public Map getStatus(){
        Map map=new HashMap<String,String>();
        map.put("app-version",appVersion);
        return map;
    }
}