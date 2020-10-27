package com.xiaoduomi.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.xiaoduomi.util.PropertiesUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

/**
 * @ClassName: RabbitmqUtil
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2020-09-28 16:44
 * @Version: 1.0
 * @Copyright: 2018~2020-09-28 16:44 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
public class RabbitmqUtil {

    private static Logger logger = Logger.getLogger(String.valueOf(RabbitmqUtil.class));

    private static PropertiesUtil propertiesUtil = new PropertiesUtil();

    public static Connection connection = null;
    public static Channel channel = null;

    private static final String KEY_HOST = "host";
    private static final String KEY_PORT = "port";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";

    private static String host;
    private static int port;
    private static String username;
    private static String password;

    static {
        try {
            host = PropertiesUtil.readProperty("rabbitmq.properties", KEY_HOST);
            port = Integer.valueOf(PropertiesUtil.readProperty("rabbitmq.properties", KEY_PORT));
            username = PropertiesUtil.readProperty("rabbitmq.properties", KEY_USERNAME);
            password = PropertiesUtil.readProperty("rabbitmq.properties", KEY_PASSWORD);

            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(host);
            factory.setPort(port);
            factory.setUsername(username);
            factory.setPassword(password);

            try {
                connection = factory.newConnection();
                channel = connection.createChannel();
            } catch (IOException e) {
                logger.warning("初始化连接RabbitMQ异常");
                e.printStackTrace();
                factory.clone();
            } catch (TimeoutException e) {
                logger.warning("初始化连接RabbitMQ超时");
                e.printStackTrace();
                factory.clone();
            }
        } catch (Exception e) {
            logger.warning("[" + RabbitmqUtil.class.getPackage().getName() + "] Failed to initialize rabbitmq configuration file ");
        }
    }

    public static void close(){
        try {
            channel.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
