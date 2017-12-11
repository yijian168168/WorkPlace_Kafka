package com.kafka.client.customer;

import com.kafka.client.dto.ConsumerInfo;
import com.kafka.client.util.IPUtil;
import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.javaapi.consumer.ConsumerConnector;

import java.util.Properties;
import java.util.UUID;

/**
 * 消费者工厂
 * Created by ZhangQingrong on 2017/7/18.
 */
public class ConsumerFactory {

    /**
     * 获取缓存的 connector
     */
    public static ConsumerConnector getConnector(ConsumerInfo customerInfo) {
        Properties properties = new Properties();
        properties.put("zookeeper.connect", customerInfo.getZkAddress());
        properties.put("group.id", customerInfo.getGroupName());
        String flag = IPUtil.localIp + "_" + customerInfo.getTopicName() + "_" + UUID.randomUUID().toString();
        properties.put("client.id", flag);
        properties.put("consumer.id", flag);
        properties.put("zookeeper.connection.timeout.ms", customerInfo.getZkConnectTimeout());
        ConsumerConnector connector = Consumer.createJavaConsumerConnector((new ConsumerConfig(properties)));
        return connector;
    }

}
