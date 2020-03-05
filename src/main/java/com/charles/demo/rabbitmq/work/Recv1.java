package com.charles.demo.rabbitmq.work;

import com.charles.demo.rabbitmq.util.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Charles
 * @date 2020年3月5日20:28:34
 */
public class Recv1 {
    private static final String QUEUE_NAME = "test_work_queue";

    public static void main(String[] args) {
        //获取链接
        try{
            Connection connection = ConnectionUtils.getConnection();
            //获取channel
            Channel channel = connection.createChannel();

            //声明队列
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            //定义一个消费者
            DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
                //一旦有消息就会触发这个方法  消息到达
                @Override
                public void handleDelivery(String consumerTag,
                                           Envelope envelope,
                                           AMQP.BasicProperties properties,
                                           byte[] body) throws IOException {
                    String msg = new String(body, "utf-8");
                    System.out.println("[1] Recv msg:" + msg);

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println("[1] done");
                    }
                }
            };

            boolean autoAck = true;
            channel.basicConsume(QUEUE_NAME, autoAck, defaultConsumer);
        }catch (IOException e){
            e.printStackTrace();
        }catch (TimeoutException e) {
            e.printStackTrace();
        }



    }
}
