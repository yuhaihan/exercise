package com.xiaoduomi.http;

import org.apache.commons.codec.Charsets;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.web.client.RestClientException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description: HttpClient工具类
 * @author: Gavin
 * @create: 2020-04-27 18:50
 * @Copyright: 2018~2020-04-27 18:50 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
public class HttpClientUtil {

    /**
     * 发送GET请求
     *
     * @param path
     * @param parametersBody
     * @return
     * @throws RestClientException
     * @throws URISyntaxException
     */
    public static String getRequest(String path, List<NameValuePair> parametersBody) throws RestClientException, URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder(path);
        uriBuilder.setParameters(parametersBody);
        HttpGet get = new HttpGet(uriBuilder.build());
        HttpClient client = HttpClientBuilder.create().build();
        try {
            HttpResponse response = client.execute(get);
            int code = response.getStatusLine().getStatusCode();
            if (code >= 400) {
                throw new RuntimeException((new StringBuilder()).append("Could not access protected resource. Server returned http code: ").append(code).toString());
            }
            return EntityUtils.toString(response.getEntity());
        } catch (ClientProtocolException e) {
            throw new RestClientException("postRequest -- Client protocol exception!", e);
        } catch (IOException e) {
            throw new RestClientException("postRequest -- IO error!", e);
        } finally {
            get.releaseConnection();
        }
    }

    /**
     * 发送POST请求（普通表单形式）
     *
     * @param path
     * @param parametersBody
     * @return
     * @throws RestClientException
     */
    public static String postForm(String path, List<NameValuePair> parametersBody) throws RestClientException {
        HttpEntity entity = new UrlEncodedFormEntity(parametersBody, Charsets.UTF_8);
        return postRequest(path, "application/x-www-form-urlencoded", entity);
    }

    /**
     * 发送POST请求（JSON形式）
     *
     * @param path
     * @param json
     * @return
     * @throws RestClientException
     */
    public static String postJSON(String path, String json) throws RestClientException {
        StringEntity entity = new StringEntity(json, Charsets.UTF_8);
        return postRequest(path, "application/json", entity);
    }

    /**
     * 发送POST请求
     *
     * @param path
     * @param mediaType
     * @param entity
     * @return
     * @throws RestClientException
     */
    public static String postRequest(String path, String mediaType, HttpEntity entity) throws RestClientException {
        HttpPost post = new HttpPost(path);
        post.addHeader("Content-Type", mediaType);
        post.addHeader("Accept", "application/json");
        post.setEntity(entity);
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpResponse response = client.execute(post);
            int code = response.getStatusLine().getStatusCode();
            if (code >= 400) {
                throw new RestClientException(EntityUtils.toString(response.getEntity()));
            }
            return EntityUtils.toString(response.getEntity());
        } catch (ClientProtocolException e) {
            throw new RestClientException("postRequest -- Client protocol exception!", e);
        } catch (IOException e) {
            throw new RestClientException("postRequest -- IO error!", e);
        } finally {
            post.releaseConnection();
        }
    }


    /**
     * 基于HttpClient 4.3的通用POST方法
     *
     * @param url       提交的URL
     * @param paramsMap 提交<参数，值>Map
     * @return 提交响应
     */

    public static String post(String url, Map<String, Object> paramsMap) {
        CloseableHttpClient client = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse response = null;
        try {
            HttpPost method = new HttpPost(url);
            if (paramsMap != null) {
                List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                for (Map.Entry<String, Object> param : paramsMap.entrySet()) {
                    NameValuePair pair = new BasicNameValuePair(param.getKey(), param.getValue().toString());
                    paramList.add(pair);
                }
                method.setEntity(new UrlEncodedFormEntity(paramList, "UTF-8"));
            }
            response = client.execute(method);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString((org.apache.http.HttpEntity) entity, "UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseText;
    }

}
