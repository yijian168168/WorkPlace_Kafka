package com.kafka.producer;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kafka.intf.KafkaProperties;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

/**
 * Kafka producer
 *
 * Created by QR on 2016/6/22.
 */
public class KafkaProducer extends Thread {

    private final Producer<String, String> producer;
    private final String topic;
    private final Properties props = new Properties();

    public KafkaProducer(String topic)
    {
//        props.put("partitioner.class", "com.kafka.partition.CidPartitioner");
        props.put("request.required.acks", "-1");
//        props.put("zookeeper.connect", KafkaProperties.zkConnect);
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("metadata.broker.list", KafkaProperties.kafkaServerURL);
        producer = new Producer<String, String>(new ProducerConfig(props));
        this.topic = topic;
    }

    @Override
    public void run() {
        int messageNo = 1;
        while (true)
        {
            String messageStr = new String("Message_" + messageNo);
            System.out.println("Send:" + messageStr);
//            List<KeyedMessage<String, String>> messages = new ArrayList<KeyedMessage<String, String>>(100);
//            messages.add(new KeyedMessage<String, String>(topic,messageStr));
            producer.send(new KeyedMessage<String, String>(topic,String.valueOf(messageNo),messageStr));
            messageNo++;
            try {
                sleep(300);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
