package org.example.mysql.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DemoUser {

    private int pk_id;
    private String nick_name;
    private String mobile;
    private String email;
}
