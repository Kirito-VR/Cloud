package org.example.mysql.service;


import org.example.mysql.domain.model.dto.RegisterDemoUserDTO;
import org.example.mysql.domain.model.vo.DemoUserVO;

public interface IDemoUserService {

    public int registerDemoUser(RegisterDemoUserDTO demoUserDTO);

    public DemoUserVO getDemoUsrInfo(int id);
}
