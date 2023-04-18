package org.example.mysql;

import lombok.extern.slf4j.Slf4j;
import org.example.mysql.domain.model.dto.RegisterDemoUserDTO;
import org.example.mysql.service.IDemoUserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class IDemoUserServiceTest {

    @Autowired
    private IDemoUserService demoUserService;

    private RegisterDemoUserDTO registerDemoUserDTO;

    @Before
    public void init(){
        this.registerDemoUserDTO = RegisterDemoUserDTO.builder()
                .nick_name("kirit")
                .mobile("15777064080")
                .email("kirit.chen@quectel.com")
                .build();
    }

    @Test
    public void test4RegisterDemoUser(){
        demoUserService.registerDemoUser(this.registerDemoUserDTO);


    }
}
