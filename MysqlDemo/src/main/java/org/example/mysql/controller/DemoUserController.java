package org.example.mysql.controller;

import org.example.mysql.domain.entity.DemoUser;
import org.example.mysql.domain.model.dto.RegisterDemoUserDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo-user")
public class DemoUserController {
    @PostMapping("/register")
    public void registerDemoUser(@RequestBody RegisterDemoUserDTO demoUserDTO){

    }
}
