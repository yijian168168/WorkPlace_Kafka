package com.qingrong;

import com.kafka.client.customer.BusinessInterface;

import java.util.Date;

/**
 * Created by ZhangQingrong on 2017/7/19.
 */
public class ConcumerBusinessImpl implements BusinessInterface<MyObject> {
    public void doBusiness(MyObject args) {
        System.out.println("receiveMsg : " + args + " , receiveTime : " + String.valueOf(new Date()));
    }
}
