package org.example.mongoDB.util;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;

import java.util.*;
import java.util.function.Consumer;


public class MongoUtil {

    private static MongoClient client;
    private static MongoDatabase mongoDatabase;

    @Value(value = "${spring.mongodb.host}")
    private static String HOST;

    @Value(value = "${spring.mongodb.port}")
    private static int PORT;
    static{
        client = new MongoClient("127.0.0.1",27017);
        mongoDatabase = client.getDatabase("collect1");
    }

    public static MongoCollection<Document> getCollection(String collectName){
        MongoCollection<Document> collection =mongoDatabase.getCollection(collectName);
        return collection;
    }

    public static List<String> getResult2List(MongoCollection<Document> collection,Document document){
        FindIterable<Document> result =  collection.find(document);

        List<String> resultList = new ArrayList<>();
        result.forEach(new Consumer<Document>(){

            @Override
            public void accept(Document document) {
                resultList.add(document.toJson());

                System.out.println("查找结果："+document.toJson());
            }
        });
        return resultList;

    }

    public static Document transMap2Document(HashMap map){
        Document document = new Document();

        Set entrys = map.entrySet();
        for(Object k:entrys){
            Map.Entry entry = (Map.Entry) k;

            String key = (String) entry.getKey();
            Object value = entry.getValue();
            System.out.println("key:"+key+"value:"+value);
            try {
                HashMap valueM = (HashMap) value;
                System.out.println("转化为HashMap"+valueM);
                document.append(key,transMap2Document(valueM));

            }catch (Exception e){
                // 存在问题，查找json字段无法加入其他类型，会类型转化错误。
                String valueS =(String) value;
                System.out.println("转化为String");
                document.append(key,valueS);

            }

            // 迭代map所有值，如果map里面有map,则递归；

        }
        return document;

    }




}
