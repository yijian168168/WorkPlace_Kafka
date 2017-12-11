package com.kafka.client.dto;

/**
 * 消费者信息
 * Created by ZhangQingrong on 2017/7/19.
 */
public class ConsumerInfo {

    /**
     * Topic 名称
     */
    private String topicName;
    /**
     * 该消费者所属组名
     */
    private String groupName;
    /**
     * zookeeper 地址（例：127.0.0.1:2181）
     */
    private String zkAddress;
    /**
     * Zookeeper连接超时
     * */
    private String zkConnectTimeout;
    /**
     * 消费者类型
     * */
    private Class customerType;

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getZkAddress() {
        return zkAddress;
    }

    public void setZkAddress(String zkAddress) {
        this.zkAddress = zkAddress;
    }

    public String getZkConnectTimeout() {
        return zkConnectTimeout;
    }

    public void setZkConnectTimeout(String zkConnectTimeout) {
        this.zkConnectTimeout = zkConnectTimeout;
    }

    public Class getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Class customerType) {
        this.customerType = customerType;
    }
}
