package org.example.mysql.controller;

import org.example.mysql.domain.model.dto.RegisterDemoUserDTO;
import org.example.mysql.domain.model.vo.DemoUserVO;
import org.example.mysql.service.IDemoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("demo-user")
public class DemoUserController {

    @Autowired
    private IDemoUserService demoUserService;

    @PostMapping("/register")
    public void registerDemoUser(@RequestBody RegisterDemoUserDTO demoUserDTO){
        demoUserService.registerDemoUser(demoUserDTO);
    }

    @GetMapping("/user-info")
    public DemoUserVO getDemoUserInfo(@RequestParam("id") int id){
        return demoUserService.getDemoUsrInfo(id);
    }
}
