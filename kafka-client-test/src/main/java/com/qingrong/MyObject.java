package com.qingrong;

/**
 * Created by ZhangQingrong on 2017/7/19.
 */
public class MyObject {

    private String sender;

    private String sendTime;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "sender='" + sender + '\'' +
                ", sendTime='" + sendTime + '\'' +
                '}';
    }
}
