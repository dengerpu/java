package com.ep.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReadYmlController {

    @Value("${name}")
    private String name;

    @Value("${person.address}")
    private String address;

    @RequestMapping("/1")
    @ResponseBody
    public String test(){
        return "name:"+name+",address:"+address ;
    }

}
