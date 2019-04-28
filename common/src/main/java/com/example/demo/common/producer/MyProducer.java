package com.example.demo.common.producer;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: CaiZiLin
 * @Date: 2019/4/24 10:36
 */
@Component
public class MyProducer {

    @Value("${rocketmq.topic}")
    private String topic;

    @Autowired(required = false)
    private RocketMQTemplate rocketMQTemplate;

    public void  sendMessage(Object message){
        rocketMQTemplate.convertAndSend(topic, message);
    }


}
