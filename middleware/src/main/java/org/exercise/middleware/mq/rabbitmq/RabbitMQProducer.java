package org.exercise.middleware.mq.rabbitmq;

import java.io.IOException;

/**
 * @ClassName: RabbitMQProducer
 * @Author: Gavin
 * @Create: 2020-09-28 17:28
 * @Version: 1.0
 * @Copyright: 2018~2020-09-28 17:28 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
@SuppressWarnings("all")
public class RabbitMQProducer {

    public void sendMessage(){
        try {
            RabbitmqUtil.channel.exchangeDeclare("my_exchange","topic",true,false,false,null);
            RabbitmqUtil.channel.queueDeclare("my_queue", true, false, false, null);
            RabbitmqUtil.channel.queueBind("my_queue", "my_exchange", "my_routing_key.#");

            //发送消息
            String msg = "hello";  //消息内容
            String routing_key = "my_routing_key.key1";  //发送消息使用的routing-key
            RabbitmqUtil.channel.basicPublish("my_exchange",routing_key,null,msg.getBytes());
            System.out.println("send message："+msg);

            RabbitmqUtil.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
