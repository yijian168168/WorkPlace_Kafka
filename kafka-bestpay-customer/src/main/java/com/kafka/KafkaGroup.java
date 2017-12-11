package com.kafka;

/**
 * kafka 组
 *
 * Created by ZhangQingrong on 2017/2/11.
 */
public enum KafkaGroup {

    GROUP_1("group1","组别1"),
    GROUP_2("group2","组别2");

    KafkaGroup(String code, String des) {
        this.code = code;
        this.des = des;
    }

    private String code;

    private String des;

    public String getCode() {
        return code;
    }

    public String getDes() {
        return des;
    }
}
