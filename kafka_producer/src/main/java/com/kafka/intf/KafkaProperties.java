package com.kafka.intf;

/**
 * 配置Kafka的各种连接参数
 *
 * Created by QR on 2016/6/22.
 */
public interface KafkaProperties {

    //Zookeeper地址
    final static String zkConnect = "172.26.7.136:2181";
    //Kafka topic
    final static String topic1 = "BillPAY_LOG_ININFS";
    final static String topic2 = "topic2";
    final static String topic3 = "topic3";
    //Kafka group
    final static String groupId1 = "billpay_group";
    final static String groupId2 = "group2";
    //Kafka server ip:port
    final static String kafkaServerURL = "172.26.7.136:39092";
    final static int kafkaProducerBufferSize = 64 * 1024;
    final static int connectionTimeOut = 20000;
    final static int reconnectInterval = 10000;
    final static String clientId = "SimpleConsumerDemoClient";
}
