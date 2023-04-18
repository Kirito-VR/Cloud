package org.example.mongoDB.controller;


import org.example.feign.pojo.vo.DemoUserVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo-user")
public class DemoUserController {



    @GetMapping("/get-result")
    public int getResult(int id){
        return 1;
    }
}
