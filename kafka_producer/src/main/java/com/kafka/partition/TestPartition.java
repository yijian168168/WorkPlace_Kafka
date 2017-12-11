package com.kafka.partition;

import kafka.producer.DefaultPartitioner;
import kafka.producer.Partitioner;
import kafka.utils.VerifiableProperties;

import java.util.Random;

/**
 * Created by QR on 2016/6/22.
 */
public class TestPartition extends DefaultPartitioner {

    public TestPartition(VerifiableProperties props) {
        super(props);
    }

    public int partition(Object key, int numPartitions) {

        System.out.print("partitions number is "+numPartitions+"   ");
        if (key == null) {
            Random random = new Random();
            System.out.println("key is null ");
            return random.nextInt(numPartitions);
        }
        else {
            int result = Math.abs(key.hashCode())%numPartitions; //很奇怪，
            //hashCode 会生成负数，奇葩，所以加绝对值
            System.out.println("key is "+ key+ " partitions is "+ result);
            return result;
        }
    }
}
