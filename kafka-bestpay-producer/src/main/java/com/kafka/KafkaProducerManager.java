package com.kafka;

import com.bestpay.kafka.model.ProducerType;
import com.bestpay.kafka.model.RequiredAck;
import com.bestpay.kafka.model.TopicInfo;
import com.bestpay.kafka.service.producer.ProducerServiceImpl;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class KafkaProducerManager {

    @Autowired
    private ProducerServiceImpl producerService;
    @Value("${zkServerUrl}")
    private String zkServerUrl;
    @Value("${kafka.url}")
    private String kafkaUrl;

    public void sendMessage(String topicName, String kafkaGroupNam, Object object){
        buildMessage(object,topicName,kafkaGroupNam, ProducerType.SYNC, RequiredAck.LEADER_ACK);
    }

    /**
     * 构造消息并发送
     * @param object 消息对象
     * @param topicName 队列名
     * @param producerType 消息类型
     * @param requiredAck
     */
    public void buildMessage(Object object,String topicName,String kafkaGroupName, ProducerType producerType,RequiredAck requiredAck){
        try{
            TopicInfo topicInfo = new TopicInfo(
                    producerType,
                    topicName,
                    requiredAck,
                    true,
                    kafkaGroupName,
                    zkServerUrl,
                    kafkaUrl
            );
            producerService.sendMessage(topicInfo,object, DateFormatUtils.format(new Date(),"yyyyMMddHHmmssSSS"));
        }catch (Exception e){
           e.printStackTrace();
        }

    }
}
