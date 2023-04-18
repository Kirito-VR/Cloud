package org.example.mysql.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.mysql.domain.entity.DemoUser;
import org.example.mysql.domain.model.dto.RegisterDemoUserDTO;
import org.example.mysql.domain.model.vo.DemoUserVO;
import org.example.mysql.mapper.DemoUserMapper;
import org.example.mysql.service.IDemoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
@Slf4j
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
        // 判断是否存在该用户
        if(filter_user!=null){
            System.out.println("查找已注册的手机号或者邮箱："+filter_user);
            return 0;
        }else {
            // 不存在则插入
            return userMapper.insert(user);
        }
    }

    @Override
    public DemoUserVO getDemoUsrInfo(int id) {

        Example example = new Example(DemoUser.class);
        example.createCriteria().andEqualTo("pk_id",id);
        DemoUser user = userMapper.selectOneByExample(example);
        DemoUser user2 = userMapper.selectByPrimaryKey(id);
        System.out.println(user2);

        DemoUserVO demoUserVO = DemoUserVO.builder()
                                            .nick_name(user.getNick_name())
                                            .mobile(user.getMobile())
                                            .email(user.getEmail())
                                            .build();
        return demoUserVO;
    }

    public int checkRegisterStyle(RegisterDemoUserDTO checkObj){
        String mobile = checkObj.getMobile();
        String email = checkObj.getEmail();
        int flag = 0;
        if(mobile==null&&email==null){
            flag = 1;
        }

        return flag;
    }

}
