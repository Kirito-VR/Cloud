package org.example.redis.controller;

import org.example.redis.pojo.Message;
import org.example.redis.service.RedisService;
import org.example.redis.util.RedisConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.HashMap;

@RestController
@RequestMapping("post")
public class PostController {

    @Autowired
    RedisService redisService;
    @PostMapping("/sendM")
    public void post2Redis(@RequestBody Message message){
        System.out.println("前端传来："+message);

        Jedis jedis = RedisConnection.getJedisConnect();

        System.out.println("测试jedis是否连接redis-server"+jedis.ping());

        redisService.startRedisSubscribe();

    }

    @PostMapping("/json4redis")
    public void post2SaveJson(@RequestBody HashMap map){
        redisService.json2Redis(map);
    }
}
