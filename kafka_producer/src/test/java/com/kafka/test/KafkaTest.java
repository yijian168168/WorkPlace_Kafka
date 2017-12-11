package com.kafka.test;

import com.kafka.customer.KafkaConsumer;
import com.kafka.intf.KafkaProperties;
import com.kafka.producer.KafkaProducer;
import org.junit.Test;

/**
 * Kafka 测试类
 *
 * Created by QR on 2016/6/22.
 */
public class KafkaTest {

    @Test
    public void testProducer() throws InterruptedException {
        KafkaProducer producerThread = new KafkaProducer(KafkaProperties.topic1);
        producerThread.start();

        Thread.sleep(60000);
    }

    /**
     * 同一个group 内的consumer会竞争获取同一条消息
     * */
    @Test
    public void testCustomer1() throws InterruptedException {
        KafkaConsumer consumerThread = new KafkaConsumer(KafkaProperties.topic2,KafkaProperties.groupId1);
        consumerThread.start();
        Thread.sleep(600000);
    }

    /**
     * 不同的group会收到相同的消息
     * */
    @Test
    public void testCustomer2() throws InterruptedException {
        KafkaConsumer consumerThread2 = new KafkaConsumer(KafkaProperties.topic1,KafkaProperties.groupId2);
        consumerThread2.start();
        Thread.sleep(600000);
    }
}
