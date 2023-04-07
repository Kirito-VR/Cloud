package org.example.redis.service;

import java.util.HashMap;

public interface RedisService {

    public void startRedisSubscribe();
    public void json2Redis(HashMap map);

}
