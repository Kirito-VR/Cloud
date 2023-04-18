package org.example.mysql.domain.model.vo;

import com.sun.tracing.dtrace.ArgsAttributes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class DemoUserVO {


    private String nick_name;
    private String mobile;
    private String email;
}
