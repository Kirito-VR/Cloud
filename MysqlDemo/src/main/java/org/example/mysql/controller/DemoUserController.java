package org.example.mysql.controller;

import org.example.mysql.domain.entity.DemoUser;
import org.example.mysql.domain.model.dto.RegisterDemoUserDTO;
import org.example.mysql.service.IDemoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo-user")
public class DemoUserController {

    @Autowired
    private IDemoUserService demoUserService;

    @PostMapping("/register")
    public void registerDemoUser(@RequestBody RegisterDemoUserDTO demoUserDTO){
        demoUserService.registerDemoUser(demoUserDTO);
    }
}
