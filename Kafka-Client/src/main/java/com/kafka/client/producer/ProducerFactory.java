package com.kafka.client.producer;

import com.kafka.client.customer.ConsumerFactory;
import com.kafka.client.dto.ProducerInfo;
import kafka.javaapi.producer.Producer;
import kafka.producer.ProducerConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者工厂
 * Created by ZhangQingrong on 2017/7/18.
 */
public class ProducerFactory {

    public static final ConcurrentMap<String, List<Producer>> topicMap = new ConcurrentHashMap<String, List<Producer>>();

    private ProducerFactory() {
    }

    public static synchronized void initProducer(ProducerInfo producerInfo) {
        if (topicMap.get(producerInfo.getTopicName()) == null || topicMap.get(producerInfo.getTopicName()).size() == 0) {
            List<Producer> producerList = new ArrayList<Producer>();
            for (int i = 0; i < producerInfo.getProducerNum(); i++) {
                Properties properties = new Properties();
                properties.put("metadata.broker.list", producerInfo.getBrokerList());
                properties.put("request.required.acks", producerInfo.getAck().getAck());
                properties.put("producer.type", producerInfo.getSyncFlag().getSyncFlag());
                properties.put("serializer.class", "kafka.serializer.StringEncoder");
                properties.put("message.send.max.retries", producerInfo.isRetries() ? "3" : "0");
                properties.put("request.timeout.ms", "3000");
                //key为null，30秒钟轮换一次分区
                properties.put("topic.metadata.refresh.interval.ms", "30000");
                producerList.add(new Producer(new ProducerConfig(properties)));
            }
            topicMap.put(producerInfo.getTopicName(), producerList);
        }
    }

    public static Producer getProducer(ProducerInfo producerInfo) {
        if (topicMap.get(producerInfo.getTopicName()) == null || topicMap.get(producerInfo.getTopicName()).size() == 0) {
            synchronized (ConsumerFactory.class) {
                initProducer(producerInfo);
            }
        }
        return topicMap.get(producerInfo.getTopicName()).get(IntegerCycle.INTEGER_CYCLE.getIndex(producerInfo.getProducerNum()));
    }

    private enum IntegerCycle {

        INTEGER_CYCLE;

        private AtomicInteger atomicInteger = new AtomicInteger();

        public int getIndex(int producerNum) {
            atomicInteger.compareAndSet(producerNum, 0);
            return atomicInteger.getAndIncrement();
        }
    }
}
