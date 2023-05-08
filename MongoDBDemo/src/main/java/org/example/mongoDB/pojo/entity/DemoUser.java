package org.example.mongoDB.pojo.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document("demo_user")
public class DemoUser {

    private String nick_name;
    private String mobile;
    private String email;
}
