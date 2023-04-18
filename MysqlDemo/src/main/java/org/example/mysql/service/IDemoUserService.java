package org.example.mysql.service;

import org.example.mysql.domain.entity.DemoUser;
import org.example.mysql.domain.model.dto.RegisterDemoUserDTO;

public interface IDemoUserService {

    public int registerDemoUser(RegisterDemoUserDTO demoUserDTO);
}
