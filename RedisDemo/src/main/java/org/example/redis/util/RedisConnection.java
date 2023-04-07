package org.example.redis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisConnection {

    private static Jedis jedisConnect;
    private static JedisPool JEDIS_POOL;

    static{
        JEDIS_POOL = new JedisPool("127.0.0.1",6379);
    }

    public static Jedis getJedisConnect(){
        if(jedisConnect==null){
            jedisConnect = new Jedis("127.0.0.1",6379);

        }if(JEDIS_POOL.getResource()!=null){

            System.out.println("使用连接池连接...");
            return JEDIS_POOL.getResource();
        }
        System.out.println("使用单连接...");
        return jedisConnect;
    }


}
