package com.qingrong;

import com.kafka.client.customer.ConsumerService;
import com.kafka.client.dto.ConsumerInfo;
import com.kafka.client.dto.ProducerInfo;
import com.kafka.client.producer.ProducerService;
import com.kafka.client.producer.ProducerType;
import com.kafka.client.producer.RequiredAck;
import org.junit.Test;

import java.util.Date;

/**
 * Created by ZhangQingrong on 2017/7/19.
 */
public class KafkaTest {

    @Test
    public void customerTest(){
        ConsumerInfo consumerInfo = new ConsumerInfo();
        consumerInfo.setGroupName("groupA");
        consumerInfo.setTopicName("topicC");
        consumerInfo.setCustomerType(MyObject.class);
        consumerInfo.setZkAddress("172.26.3.10:2181");
        consumerInfo.setZkConnectTimeout("3000");
        ConsumerService.startDoBusiness(consumerInfo,new ConcumerBusinessImpl());
    }

    @Test
    public void producerTest() throws InterruptedException {
        for (int i=0;i<10000;i++) {
            ProducerInfo producerInfo = new ProducerInfo();
            producerInfo.setTopicName("topicC");
            producerInfo.setAck(RequiredAck.NO_ACK);
            producerInfo.setRetries(true);
            producerInfo.setSyncFlag(ProducerType.ASYNC);
            producerInfo.setBrokerList("172.26.3.10:9092");
            producerInfo.setProducerNum(5);
            MyObject myObject = new MyObject();
            myObject.setSender("qingrong");
            myObject.setSendTime(String.valueOf(new Date()));
            ProducerService.sendMessae(producerInfo, myObject);
            System.out.println("send success   " + myObject);
            Thread.sleep(10);
        }
        Thread.sleep(600000);
    }
}
