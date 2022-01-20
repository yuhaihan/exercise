package org.exercise.middleware.mq.rabbitmq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;

/**
 * @ClassName: RabbitMQProducer
 * @Author: Gavin
 * @Create: 2020-09-28 17:38
 * @Version: 1.0
 * @Copyright: 2018~2020-09-28 17:38 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
public class RabbitMQConsumer {

    public static void receive(){
        DefaultConsumer consumer = new DefaultConsumer(RabbitmqUtil.channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body);
                System.out.println("received msg: " + msg);
            }
        };
    }
}
