package com.kafka.client.customer;

/**
 * Created by ZhangQingrong on 2017/7/18.
 */
public interface BusinessInterface<T> {

    /**
     * 业务处理
     */
    public abstract void doBusiness(T args);
}
