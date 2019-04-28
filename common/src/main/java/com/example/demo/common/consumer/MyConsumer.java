package com.example.demo.common.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: CaiZiLin
 * @Date: 2019/4/23 20:22
 */
@Component
@RocketMQMessageListener(topic="${rocketmq.topic}", consumerGroup = "${rocketmq.consumer.group}")
public class MyConsumer implements RocketMQListener<String> {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(MyConsumer.class);
    @Override
    public void onMessage(String s) {
        logger.info(s);
    }
}
