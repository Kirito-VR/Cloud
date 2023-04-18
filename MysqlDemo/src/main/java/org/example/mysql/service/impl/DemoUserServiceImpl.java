package org.example.mysql.service.impl;

import org.example.mysql.domain.entity.DemoUser;
import org.example.mysql.domain.model.dto.RegisterDemoUserDTO;
import org.example.mysql.mapper.DemoUserMapper;
import org.example.mysql.service.IDemoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

public class DemoUserServiceImpl implements IDemoUserService {

    @Autowired
    private DemoUserMapper userMapper;

    @Override
    public int registerDemoUser(RegisterDemoUserDTO demoUserDTO) {
        /*
         * 注册功能，实现Demo用户的注册
         * 1.查询邮箱是否存在；2.查询手机号是否存在；3.执行插入操作
         *
         * */
        // registerDTO数据转化为
        DemoUser user = DemoUser.builder()
                .nick_name(demoUserDTO.getNick_name())
                .email(demoUserDTO.getEmail())
                .mobile(demoUserDTO.getMobile())
                .build();
        System.out.println("注册数据:"+ demoUserDTO.getNick_name());
        System.out.println("用户数据:"+user.toString());


        // 查找user，by mobile or email
        // 构建查询 Example
        Example example = new Example(DemoUser.class);
        example.createCriteria()
                .orEqualTo("mobile",user.getMobile())
                .orEqualTo("email",user.getEmail());

        DemoUser filter_user = userMapper.selectOneByExample(example);
        System.out.println("查找已注册的手机号或者邮箱："+filter_user);

        return 0;
    }
}
