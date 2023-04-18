package org.example.mysql.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@Table(name = "demo_user")
@AllArgsConstructor
public class DemoUser {

    @Id
    @GeneratedValue(generator = "JDBC")
    private int pk_id;
    private String nick_name;
    private String mobile;
    private String email;

    public DemoUser() {
    }

}
