package org.example.mongoDB.service.impl;

import org.example.feign.client.MysqlClient;
import org.example.mongoDB.service.IDemoUserMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoUserMongoServiceImpl implements IDemoUserMongoService {
    @Autowired
    MysqlClient client;
    @Override
    public void getResult(int id) {
        client.getUserVO(id);
    }
}
