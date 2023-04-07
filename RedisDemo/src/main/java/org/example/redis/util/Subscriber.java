package org.example.redis.util;

import redis.clients.jedis.JedisPubSub;

public class Subscriber extends JedisPubSub {

    @Override
    public void onMessage(String channel, String message) {
        System.out.println("onMessage---Channel："+channel+"Message:"+message);
    }

    @Override
    public void onPMessage(String pattern, String channel, String message) {
        System.out.println("onPMessage---Channel："+channel+"Message:"+message+"pattern:"+pattern);
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.println("onSubscribe---Channel："+channel+"SubscribedChannels:"+subscribedChannels);
    }

    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
        System.out.println("onPUnsubscribe---Pattern："+pattern+"SubscribedChannels:"+subscribedChannels);
    }

    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        System.out.println("onPSubscribe---Pattern："+pattern+"SubscribedChannels:"+subscribedChannels);;
    }
}
