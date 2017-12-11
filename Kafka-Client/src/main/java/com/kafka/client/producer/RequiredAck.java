package com.kafka.client.producer;

/**
 * 应答标识
 * Created by ZhangQingrong on 2017/7/18.
 */
public enum  RequiredAck {

    NO_ACK("0","无需应答(消息异步))"),
    LEADER_ACK("1","leader应答(同步消息，主节点应答)"),
    ALL_ACK("-1","全部应答(同步消息，主从节点都应答)");

    private String ack;
    private String description;

    RequiredAck(String ack, String description) {
        this.ack = ack;
        this.description = description;
    }

    public String getAck() {
        return ack;
    }

    public void setAck(String ack) {
        this.ack = ack;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
