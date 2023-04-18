package org.example.mysql.domain.model.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterDemoUserDTO {

    private String nick_name;
    private String mobile;
    private String email;

}
