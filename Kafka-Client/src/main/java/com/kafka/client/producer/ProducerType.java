package com.kafka.client.producer;

/**
 * 消息同步、异步标示
 * Created by ZhangQingrong on 2017/7/18.
 */
public enum  ProducerType {

    SYNC("sync","同步消息"),
    ASYNC("async","异步消息");

    private String syncFlag;
    private String description;

    ProducerType(String syncFlag,String description){
        this.syncFlag = syncFlag;
        this.description = description;
    }

    public String getSyncFlag() {
        return syncFlag;
    }

    public void setSyncFlag(String syncFlag) {
        this.syncFlag = syncFlag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
