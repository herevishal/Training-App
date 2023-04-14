package com.myapp.security;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/rest/hello")
public class DemoController
{
    @ResponseBody 
    @GetMapping
    public String hello()
    {
        return "hello world";
    }    
   
}