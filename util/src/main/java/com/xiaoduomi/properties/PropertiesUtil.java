package com.xiaoduomi.properties;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;


/**
 * @ClassName: PropertiesUtil
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2020-09-28 16:24
 * @Version: 1.0
 * @Copyright: 2018~2020-09-28 16:24 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
@Slf4j
public class PropertiesUtil {

    private static Logger logger = Logger.getLogger(String.valueOf(PropertiesUtil.class));

    private static Properties properties = new Properties();

    public static String readProperty(String propertyName, String propertyKey){
        try {
            InputStream inputStream = ClassLoader.getSystemResourceAsStream(propertyName);
            properties.load(inputStream);
            return (String)properties.get(propertyKey);
        }catch (Exception e){
            logger.warning("读取rabbitmq.properties文件异常");
        }
        return null;
    }

}
