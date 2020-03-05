package com.charles.demo.rabbitmq.work;

import com.charles.demo.rabbitmq.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Charles
 * @date 2020年3月5日20:31:43
 */
public class Send {
    /**
     * \----C1
     * p--------Queue-----\
     * \----C2
     *
     * @param args
     */
    private static final String QUEUE_NAME = "test_work_queue";

    public static void main(String[] args) {
        try {
            //获取中间件链接
            Connection connection = ConnectionUtils.getConnection();

            //获取channel
            Channel channel = connection.createChannel();

            //声明队列
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            int num = 50;
            for (int i = 0; i < num; i++) {
                String msg = "hello" + i;
                System.out.println("[ WQ ] Send:" + msg);
                channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
                Thread.sleep(i * 20);
            }

            channel.close();
            connection.close();
        } catch (IOException e) {
            System.out.println("error while IO!!!");
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.out.println("error with no respond!!!");
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("error for being interrupted!!!");
        }

    }
}
