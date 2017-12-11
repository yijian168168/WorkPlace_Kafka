package com.kafka.test;

import com.kafka.KafkaBusinessProcess;
import com.kafka.KafkaCustomerManager;
import com.kafka.KafkaGroup;
import com.kafka.KafkaTopic;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ZhangQingrong on 2017/2/11.
 */
public class KafkaTest {

    private KafkaCustomerManager kafkaCustomerManager;

    @Before
    public void init() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/spring.xml");
        kafkaCustomerManager = applicationContext.getBean(KafkaCustomerManager.class);
    }

    @Test
    public void test1() throws InterruptedException {
       kafkaCustomerManager.message(KafkaTopic.TOPIC_A.getCode(),KafkaGroup.GROUP_1.getCode(), KafkaBusinessProcess.class);
       Thread.sleep(60000000);
    }

    @Test
    public void test2() throws InterruptedException {
        kafkaCustomerManager.message(KafkaTopic.TOPIC_A.getCode(),KafkaGroup.GROUP_1.getCode(), KafkaBusinessProcess.class);
        Thread.sleep(60000000);
    }

    @Test
    public void test3() {
        kafkaCustomerManager.message(KafkaTopic.TOPIC_B.getCode(),KafkaGroup.GROUP_1.getCode(), KafkaBusinessProcess.class);
    }



}
