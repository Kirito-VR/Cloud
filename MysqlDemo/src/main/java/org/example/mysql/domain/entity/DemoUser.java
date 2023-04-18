package org.example.mysql.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class DemoUser {

    private int pk_id;
    private String nick_name;
    private String mobile;
    private String email;

    public DemoUser() {
    }

}
