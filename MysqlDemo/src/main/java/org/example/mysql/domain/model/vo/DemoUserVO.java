package org.example.mysql.domain.model.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DemoUserVO {


    private String nick_name;
    private String mobile;
    private String email;
}
