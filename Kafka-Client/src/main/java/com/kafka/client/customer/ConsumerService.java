package com.kafka.client.customer;

import com.alibaba.fastjson.JSON;
import com.kafka.client.dto.ConsumerInfo;
import com.kafka.client.util.KafkaClientStringUtils;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.consumer.TopicFilter;
import kafka.consumer.Whitelist;
import kafka.message.MessageAndMetadata;
import kafka.serializer.Decoder;
import kafka.serializer.StringDecoder;
import kafka.utils.VerifiableProperties;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 消费者服务
 * Created by ZhangQingrong on 2017/7/18.
 */
@Slf4j
public class ConsumerService {
    /**
     * 消费者，此方法被调用一次即生成一个消费者
     */
    public static void startDoBusiness(ConsumerInfo customerInfo, BusinessInterface business) {
        TopicFilter topicFilter = new Whitelist(customerInfo.getTopicName());
        Decoder decoder = new StringDecoder(new VerifiableProperties());
        List<KafkaStream> consumerList = ConsumerFactory.getConnector(customerInfo).createMessageStreamsByFilter(topicFilter, 1, decoder, decoder);
        for (KafkaStream stream : consumerList) {
            ConsumerIterator consumerIterator = stream.iterator();
            while (consumerIterator.hasNext()) {
                try {
                    MessageAndMetadata messageAndMetadata = consumerIterator.next();
                    log.info("start to doBusiness , topic:{}, partition:{}, offset:{} .",
                            messageAndMetadata.topic(), messageAndMetadata.partition(), messageAndMetadata.offset());
                    String message = (String) messageAndMetadata.message();
                    Object param = JSON.parseObject(message, customerInfo.getCustomerType());
                    business.doBusiness(param);
                }catch (Exception e){
                    log.error("doBusiness error , {}", KafkaClientStringUtils.getStackTraceAsString(e));
                }

            }
        }
    }
}
