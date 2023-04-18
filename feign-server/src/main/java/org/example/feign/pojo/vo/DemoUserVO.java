package org.example.feign.pojo.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DemoUserVO {


    private String nick_name;
    private String mobile;
    private String email;
}
