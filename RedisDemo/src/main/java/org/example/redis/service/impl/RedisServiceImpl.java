package org.example.redis.service.impl;

import org.example.feign.client.MongoDBClient;
import org.example.redis.service.RedisService;
import org.example.redis.util.RedisConnection;
import org.example.redis.util.RedisUtil;
import org.example.redis.util.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;

@Service
public class RedisServiceImpl implements RedisService {

    // 线程号；
    private static int threadnum = 0;

    // MongoDB的Api客户端
    @Autowired
    MongoDBClient client;
    @Override
    public void startRedisSubscribe() {
        Jedis jedis4subscribe = RedisConnection.getJedisConnect();
        System.out.println("Redis连接----连接返回值："+jedis4subscribe.ping());

        // 开启线程做服务状态
        new Thread(new Runnable() {

            @Override
            public void run() {
                threadnum++;
                System.out.println("订阅服务启动----线程"+threadnum);

                jedis4subscribe.subscribe(new Subscriber(),"Channel_In_Java");
            }
        }).start();
    }


    @Override
    public void json2Redis(HashMap map) {
        // 自Mongo获得id数据
        List<String> jsonList = client.postJson4Result(map);
        System.out.println(jsonList);
        // 获得Redis连接
        Jedis jedis = RedisConnection.getJedisConnect();
        RedisUtil.putJson2Redis(jedis,jsonList);

        // 解析Mongojson数据并导入Redis中以id:json【Hash方式存储】

        // 关闭资源；
        jedis.close();
    }
}
