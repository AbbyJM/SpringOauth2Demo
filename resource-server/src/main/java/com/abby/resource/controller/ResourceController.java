package com.abby.resource.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    @RequestMapping(value = "/public")
    public String publicResource(){
        return "the public resource";
    }

    @RequestMapping(value = "/private")
    public String user(){
        return "hi,this is the protected resource";
    }
}
