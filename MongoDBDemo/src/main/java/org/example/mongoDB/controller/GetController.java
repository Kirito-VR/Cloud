package org.example.mongoDB.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("get")
public class GetController {

    @GetMapping("/id")
    public String getId4Json(@RequestParam int id){


        return new String("asdfsdfs");
    }
}
