package org.example.redis.controller;


import org.example.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("get")
public class GetController {

    @Autowired
    RedisService service;

    @GetMapping("/id")
    public void get2Json4Redis(@RequestParam int id){
        System.out.println("前端传回id:"+id);
//        service.json2Redis(id);

    }
}
