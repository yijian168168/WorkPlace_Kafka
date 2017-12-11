package com.kafka.client.producer;

import com.alibaba.fastjson.JSON;
import com.kafka.client.dto.ProducerInfo;
import kafka.producer.KeyedMessage;

/**
 * 生产者服务
 * Created by ZhangQingrong on 2017/7/18.
 */
public class ProducerService {
    /**
     * 发送消息
     * */
    public static <T> void sendMessae(ProducerInfo producerInfo, T message) {
        String stringMsg = JSON.toJSONString(message,false);
        ProducerFactory.getProducer(producerInfo).send(new KeyedMessage(producerInfo.getTopicName(), stringMsg));
    }
}
