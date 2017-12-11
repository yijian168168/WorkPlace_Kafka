package com.kafka;

/**
 * kafka 主题
 *
 * Created by ZhangQingrong on 2017/2/11.
 */
public enum  KafkaTopic {

    TOPIC_A("topic-A","主题A"),
    TOPIC_B("topic-B","主题B");

    KafkaTopic(String code, String des) {
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
