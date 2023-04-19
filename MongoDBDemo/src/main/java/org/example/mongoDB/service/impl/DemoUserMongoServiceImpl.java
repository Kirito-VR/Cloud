package org.example.mongoDB.service.impl;

import com.alibaba.fastjson.JSON;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.example.feign.client.MysqlClient;
import org.example.feign.pojo.vo.DemoUserVO;
import org.example.mongoDB.service.IDemoUserMongoService;
import org.example.mongoDB.util.MongoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DemoUserMongoServiceImpl implements IDemoUserMongoService {
    @Autowired
    MysqlClient client;
    @Override
    public void getResult(int id) {
        DemoUserVO userVO = client.getUserVO(id);
        System.out.println(userVO.toString());

        // save DemoUserVO in MongoDB

        HashMap map= JSON.parseObject(JSON.toJSONString(userVO), HashMap.class);
        Document document=  MongoUtil.transMap2Document(map);
        MongoCollection<Document> conn = MongoUtil.getCollection("demo_user");
        conn.insertOne(document);



    }
}
