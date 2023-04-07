package org.example.redis.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

public class RedisUtil {


    public static void putJson2Redis(Jedis jedis, List<String> jsons){


        jsons.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                HashMap map = JSON.parseObject(s,new TypeReference<HashMap>(){});
                jedis.lpush("maplist",s);
                jedis.expire("maplist",60);
                System.out.println("转化成map"+map);
            }
        });


    }
}
