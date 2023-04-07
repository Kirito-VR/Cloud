package org.example.mongoDB.controller;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.example.mongoDB.pojo.Message;
import org.example.mongoDB.util.MongoUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

@RestController
@RequestMapping("post")
public class PostController {

    @PostMapping("/send2Mongo")
    public void sendM4Mongo(@RequestBody Message message){

        MongoCollection<Document>  collection = MongoUtil.getCollection("collect1");
        FindIterable<Document> findIterable = collection.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        while(mongoCursor.hasNext()){
            System.out.println(mongoCursor.next());
        }

        FindIterable<Document> findSomeIterable = collection.find(new Document("deviceId","1002"));
        findSomeIterable.forEach(new Consumer<Document>() {
            @Override
            public void accept(Document document) {
                System.out.println("json:"+document.toJson());
            }
        });

        Document document = new Document("deviceId", message.getId())
                .append("deviceName",message.getUsername())
                .append("alarmType","低电量告警")
                .append("alarmNum",30)
                .append("message",message.getObj());

        collection.insertOne(document);


    }


    @PostMapping("/update")
    public void send4Update(@RequestBody Message message){
        MongoCollection<Document> collection = MongoUtil.getCollection("collect1");
        collection.updateMany(Filters.eq("deviceId",1234),new Document("$set",new Document("deviceId",1005)));

    }


    @PostMapping("/json")
    public List<String> send4Json(@RequestBody HashMap map){
        Set s = map.entrySet();
        for(Object m:s){
            Map.Entry entry = (Map.Entry)m;
            System.out.println("  key:" + entry.getKey()+"  value:" + entry.getValue());

        }

        Document document = MongoUtil.transMap2Document(map);
        System.out.println("转化后的Document:"+document);

        MongoCollection<Document> collection = MongoUtil.getCollection("collect1");
        List<String> result = MongoUtil.getResult2List(collection,document);

        System.out.println("result:"+result);
        return result;
    }

}
