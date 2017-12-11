package com.kafka.client.util;

import lombok.extern.slf4j.Slf4j;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * 获取机器ip
 * Created by ZhangQingrong on 2017/7/18.
 */
@Slf4j
public class IPUtil {

    public static String localIp = "888.888.888.888";

    static {
        try {
            Enumeration allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip;
            boolean getIp = false;
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                Enumeration addresses = netInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    ip = (InetAddress) addresses.nextElement();
                    if (ip != null && ip instanceof Inet4Address) {
                        localIp = ip.getHostAddress();
                        getIp = true;
                        break;
                    }
                }
                if (getIp) {
                    break;
                }
            }
            log.info("localIP : {}", localIp);
        } catch (Exception e) {
            log.error("get localIP error , {}", KafkaClientStringUtils.getStackTraceAsString(e));
        }
    }
}
