package com.exercies.es.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: ElasticsearchConfig
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2020-11-09 11:07
 * @Version: 1.0
 * @Copyright: 2018~2020-11-09 11:07 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
@Configuration
public class ElasticsearchConfig {


    public static final RequestOptions esOptions;

    static {
        RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();
        esOptions = builder.build();
    }

    @Bean
    public RestHighLevelClient restClient() {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("192.168.65.128", 9200, "http")));
        return client;
    }

}
