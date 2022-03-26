package com.xiaoduomi.http;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;

/**
 * @ClassName: CloseHttpUtil
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2022-03-26 14:41
 * @Version: 1.0
 * @Copyright: 2018~2022-03-26 14:41 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
public class CloseHttpUtil {

    public static void close(CloseableHttpResponse response, CloseableHttpClient httpClient) {
        if (null != response) {
            try {
                response.close();
                httpClient.close();
            } catch (IOException e) {
                System.err.println("释放连接出错");
                e.printStackTrace();
            }
        }
    }

    public static void setTimeOut(HttpGet httpGet) {
        RequestConfig requestConfig = RequestConfig.custom()
                // 设置连接超时时间(单位毫秒)
                .setConnectTimeout(10000)
                // 设置请求超时时间(单位毫秒)
                .setConnectionRequestTimeout(10000)
                // socket读写超时时间(单位毫秒)
                .setSocketTimeout(10000)
                // 设置是否允许重定向(默认为true)
                .setRedirectsEnabled(true).build();
        // 将上面的配置信息 运用到这个Get请求里
        httpGet.setConfig(requestConfig);
    }

}
