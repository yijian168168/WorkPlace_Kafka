package com.kafka;

import com.bestpay.kafka.service.consumer.process.BusinessProcessInterface;
import org.springframework.stereotype.Service;

/**
 * Created by ZhangQingrong on 2017/2/12.
 */
@Service
public class KafkaBusinessProcess extends BusinessProcessInterface<String> {

    public void doBusiness(String args) {
        System.out.println(args);
    }
}
