package com.charles.demo.rabbitmq.workfair;

import com.charles.demo.rabbitmq.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;


import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {
    /**
     *                      \----C1
     *   p--------Queue-----\
     *                      \----C2
     * @param args
     * @throws IOException
     * @throws TimeoutException
     */
    private static final String QUEUE_NAME="test_work_queue";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        //获取中间件链接
        Connection connection = ConnectionUtils.getConnection();

        //获取channel
        Channel channel = connection.createChannel();

        //声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        /**
         * 每个消费者发送确认消息之前，消息队列不发送下一个消息到消费者，一次只处理一个消息
         * 限制发送给同一个消费者，不能超过一条消息
         */
        int prefetchCount=1;
        channel.basicQos(prefetchCount);

        for(int i=0;i<50;i++){
            String msg="hello"+i;
            System.out.println("[ WQ ] Send:"+msg);
            channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
            Thread.sleep(i*5);
        }

        channel.close();
        connection.close();
    }
}
