package com.kafka.test;

import com.kafka.KafkaGroup;
import com.kafka.KafkaProducerManager;
import com.kafka.KafkaTopic;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by ZhangQingrong on 2017/2/11.
 */
public class KafkaTest {

    private KafkaProducerManager kafkaProducerManager;

    @Before
    public void init() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/spring.xml");

        kafkaProducerManager = applicationContext.getBean(KafkaProducerManager.class);
    }

    @Test
    public void test1() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            String message = "message a " + DateFormatUtils.format(new Date(), "yyyyMMddHHmmssSSS");
            kafkaProducerManager.sendMessage(KafkaTopic.TOPIC_A.getCode(), KafkaGroup.GROUP_1.getCode(), message);
            System.out.println("send success");
            Thread.sleep(1000);
        }
    }

    @Test
    public void test2() {
        String message = "message a " + DateFormatUtils.format(new Date(), "yyyyMMddHHmmssSSS");
        kafkaProducerManager.sendMessage(KafkaTopic.TOPIC_A.getCode(), KafkaGroup.GROUP_2.getCode(), message);
    }

    @Test
    public void test3() {
        String message = "message a " + DateFormatUtils.format(new Date(), "yyyyMMddHHmmssSSS");
        kafkaProducerManager.sendMessage(KafkaTopic.TOPIC_B.getCode(), KafkaGroup.GROUP_1.getCode(), message);
    }

}
