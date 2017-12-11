package com.kafka;

import com.bestpay.kafka.model.ProducerType;
import com.bestpay.kafka.model.RequiredAck;
import com.bestpay.kafka.model.TopicInfo;
import com.bestpay.kafka.service.consumer.ConsumerServiceImpl;
import com.bestpay.kafka.service.producer.ProducerServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.UUID;

/**
 * kafka消费者
 *
 * Created by ZhangQingrong on 2017/2/12.
 */
@Service
public class KafkaCustomerManager {

    @Autowired
    private ConsumerServiceImpl consumerService;
    @Value("${zkServerUrl}")
    private String zkServerUrl;
    @Value("${kafka.url}")
    private String kafkaUrl;

    public void message(String topicName, String kafkaGroupName, Class clazz){
        try {
            TopicInfo topicInfo = new TopicInfo(
                    ProducerType.SYNC,
                    topicName,
                    RequiredAck.LEADER_ACK,
                    true,
                    kafkaGroupName,
                    zkServerUrl,
                    kafkaUrl
            );
            consumerService.consumerMessages(
                    topicInfo,
                    clazz,
                    UUID.randomUUID().toString());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
