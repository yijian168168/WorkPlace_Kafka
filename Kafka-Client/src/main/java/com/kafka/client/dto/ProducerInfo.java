package com.kafka.client.dto;

import com.kafka.client.producer.ProducerType;
import com.kafka.client.producer.RequiredAck;

/**
 * 生产者信息
 * Created by ZhangQingrong on 2017/7/19.
 */
public class ProducerInfo {

    /**
     * Topic 名称
     */
    private String topicName;
    /**
     * 消息类型 同步、异步
     */
    private ProducerType syncFlag;
    /**
     * 消息发送后的应答方式
     */
    private RequiredAck ack;
    /**
     * 消息发送异常后是否可以重复发送（重复时可能消息重复）
     */
    private boolean retries;
    /**
     * 集群地址列表（例如：172.17.13.41:9092,172.17.13.42:9092）
     */
    private String brokerList;
    /**
     * 建立生产者个数
     * */
    private int producerNum = 1;

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public ProducerType getSyncFlag() {
        return syncFlag;
    }

    public void setSyncFlag(ProducerType syncFlag) {
        this.syncFlag = syncFlag;
    }

    public RequiredAck getAck() {
        return ack;
    }

    public void setAck(RequiredAck ack) {
        this.ack = ack;
    }

    public boolean isRetries() {
        return retries;
    }

    public void setRetries(boolean retries) {
        this.retries = retries;
    }

    public String getBrokerList() {
        return brokerList;
    }

    public void setBrokerList(String brokerList) {
        this.brokerList = brokerList;
    }

    public int getProducerNum() {
        return producerNum;
    }

    public void setProducerNum(int producerNum) {
        this.producerNum = producerNum;
    }
}
