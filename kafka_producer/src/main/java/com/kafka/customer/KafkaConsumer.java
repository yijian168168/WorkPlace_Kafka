package com.kafka.customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.kafka.intf.KafkaProperties;
import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;

/**
 * Kafka consumer
 *
 * Created by QR on 2016/6/22.
 */
public class KafkaConsumer extends Thread{

    private final ConsumerConnector consumer;
    private final String topic;

    public KafkaConsumer(String topic,String group) {
        Properties props = new Properties();
        props.put("zookeeper.connect", KafkaProperties.zkConnect);
        props.put("group.id", group);
        props.put("zookeeper.session.timeout.ms", "40000");
        props.put("zookeeper.sync.time.ms", "200");
        props.put("auto.commit.interval.ms", "1000");
        props.put("rebalance.max.retries", "10");

        props.put("zookeeper.connection.timeout.ms", "10000");
        props.put("rebalance.backoff.ms", "2000");
        consumer = Consumer.createJavaConsumerConnector(new ConsumerConfig(props));
        this.topic = topic;
    }

    @Override
    public void run() {
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(topic, new Integer(1));
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
        KafkaStream<byte[], byte[]> stream = consumerMap.get(topic).get(0);
        ConsumerIterator<byte[], byte[]> it = stream.iterator();
        while (it.hasNext()) {
            MessageAndMetadata<byte[],byte[]> metadata = it.next();
            System.out.println("receive：" + new String(metadata.message()) + ", partition: " + metadata.partition());
            try {
                sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
