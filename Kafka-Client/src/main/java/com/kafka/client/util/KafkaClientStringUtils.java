package com.kafka.client.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 字符串工具类
 * Created by ZhangQingrong on 2017/7/19.
 */
public class KafkaClientStringUtils {

    /**
     * 将堆栈在一行打印
     * */
    public static String getStackTraceAsString(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

}
