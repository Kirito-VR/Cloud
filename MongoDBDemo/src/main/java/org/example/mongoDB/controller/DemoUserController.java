package org.example.mongoDB.controller;


import org.example.feign.pojo.vo.DemoUserVO;
import org.example.mongoDB.service.IDemoUserMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo-user")
public class DemoUserController {

    @Autowired
    IDemoUserMongoService demoUserMongoService;

    @GetMapping("/get-result")
    public int getResult(@RequestParam("id") int id){
        demoUserMongoService.getResult(id);
        return 1;
    }

    @GetMapping("/get2insert")
    public int get2Insert(@RequestParam("id")int id){
        demoUserMongoService.insertResult(id);
        return 1;
    }

}
