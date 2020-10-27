package com.xiaoduomi.consumer;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.xiaoduomi.rabbitmq.RabbitmqUtil;

import java.io.IOException;

/**
 * @ClassName: RabbitMQProducer
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2020-09-28 17:38
 * @Version: 1.0
 * @Copyright: 2018~2020-09-28 17:38 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
public class RabbitMQProducer {

    public static void receive(){
        DefaultConsumer consumer = new DefaultConsumer(RabbitmqUtil.channel){
            @Override
            public void handleDelivery(java.lang.String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                java.lang.String msg = new java.lang.String(body);
                System.out.println("received msg: " + msg);
            }
        };
    }
}
