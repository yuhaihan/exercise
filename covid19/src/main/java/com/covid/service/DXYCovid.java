package com.covid.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xiaoduomi.http.HttpClientUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: DXYCovid
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2022-03-26 14:34
 * @Version: 1.0
 * @Copyright: 2018~2022-03-26 14:34 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */

public class DXYCovid {



    public static void getAreaStat(){
        String url = "https://ncov.dxy.cn/ncovh5/view/pneumonia";
        HttpClientUtil httpClientUtil = new HttpClientUtil();
        Map<String, String> headMap = new HashMap<>();
        String htmlResult = HttpClientUtil.doGetRequestNoparam(url, headMap);

        //正则获取数据
        //因为html的数据格式看着就像json格式，所以我们正则获取json
        String reg= "window.getAreaStat = (.*?)\\}(?=catch)";
        Pattern totalPattern = Pattern.compile(reg);
        Matcher totalMatcher = totalPattern.matcher(htmlResult);

        String result="";
        if (totalMatcher.find()){
            result = totalMatcher.group(1);
            System.out.println(result);
            //各个省市的是一个列表List
            JSONArray array = JSONArray.parseArray(result);
            JSONObject jsonObject = JSONObject.parseObject(array.getString(0));
            String provinceName = jsonObject.getString("provinceName");
            System.out.println("provinceName："+provinceName);
        }

    }


    /**
     * 统计总数量
     * @return
     */
    public static String getStatisticsService(){
        String url = "https://ncov.dxy.cn/ncovh5/view/pneumonia";
        HttpClientUtil httpClientUtil = new HttpClientUtil();
        Map<String, String> headMap = new HashMap<>();
        String htmlResult = HttpClientUtil.doGetRequestNoparam(url, headMap);



        //正则获取数据
        //因为html的数据格式看着就像json格式，所以我们正则获取json：{"id":1,"createTime":1579537899000,"modifyTime":1580571956000,"infectSource":"野生动物，可能为中华菊头蝠","passWay":"经呼吸道飞沫传播，亦可通过接触传播","imgUrl":"https://img1.dxycdn.com/2020/0201/450/3394153392393266839-135.png","dailyPic":"https://img1.dxycdn.com/2020/0201/693/3394145745204021706-135.png","summary":"","deleted":false,"countRemark":"","confirmedCount":11901,"suspectedCount":17988,"curedCount":275,"deadCount":259,"virus":"新型冠状病毒 2019-nCoV","remark1":"易感人群: 人群普遍易感。老年人及有基础疾病者感染后病情较重，儿童及婴幼儿也有发病","remark2":"潜伏期: 一般为 3~7 天，最长不超过 14 天，潜伏期内存在传染性","remark3":"","remark4":"","remark5":"","generalRemark":"疑似病例数来自国家卫健委数据，目前为全国数据，未分省市自治区等","abroadRemark":""}
        String reg= "window.getStatisticsService = (.*?)\\}(?=catch)";
        Pattern totalPattern = Pattern.compile(reg);
        Matcher totalMatcher = totalPattern.matcher(htmlResult);

        String result="";
        if (totalMatcher.find()){
            result = totalMatcher.group(1);
            System.out.println(result);
            JSONObject jsonObject = JSONObject.parseObject(result);
        }
        return result;
    }


    /**
     * 获取页面的实时播报 1
     * @return
     */
    public static String getTimelineService1() {
        String url = "https://ncov.dxy.cn/ncovh5/view/pneumonia";
        HttpClientUtil httpClientUtil = new HttpClientUtil();
        Map<String, String> headMap = new HashMap<>();
        String htmlResult = HttpClientUtil.doGetRequestNoparam(url, headMap);

        //正则获取数据
        //因为html的数据格式看着就像json格式，所以我们正则获取json
        String reg = "window.getTimelineService1 = (.*?)\\}(?=catch)";
        Pattern totalPattern = Pattern.compile(reg);
        Matcher totalMatcher = totalPattern.matcher(htmlResult);

        String result = "";
        if (totalMatcher.find()) {
            result = totalMatcher.group(1);
            System.out.println(result);
            //是一个列表List
            JSONArray array = JSONArray.parseArray(result);


        }

        return result;
    }

    /**
     * 获取页面的实时播报 2
     * @return
     */
    public static String getTimelineService2() {
        String url = "https://ncov.dxy.cn/ncovh5/view/pneumonia";
        HttpClientUtil httpClientUtil = new HttpClientUtil();
        Map<String, String> headMap = new HashMap<>();
        String htmlResult = HttpClientUtil.doGetRequestNoparam(url, headMap);

        //正则获取数据
        //因为html的数据格式看着就像json格式，所以我们正则获取json
        String reg = "window.getTimelineService2 = (.*?)\\}(?=catch)";
        Pattern totalPattern = Pattern.compile(reg);
        Matcher totalMatcher = totalPattern.matcher(htmlResult);

        String result = "";
        if (totalMatcher.find()) {
            result = totalMatcher.group(1);
            System.out.println(result);
            //是一个列表List
            JSONArray array = JSONArray.parseArray(result);


        }

        return result;
    }


    /**
     * 获取最近统计数据信息
     * @return
     */
    public static String getFetchRecentStat() {
        String url = "https://ncov.dxy.cn/ncovh5/view/pneumonia";
        HttpClientUtil httpClientUtil = new HttpClientUtil();
        Map<String, String> headMap = new HashMap<>();
        String htmlResult = HttpClientUtil.doGetRequestNoparam(url, headMap);

        //正则获取数据
        //因为html的数据格式看着就像json格式，所以我们正则获取json
        String reg = "window.fetchRecentStat = (.*?)\\}(?=catch)";
        Pattern totalPattern = Pattern.compile(reg);
        Matcher totalMatcher = totalPattern.matcher(htmlResult);

        String result = "";
        if (totalMatcher.find()) {
            result = totalMatcher.group(1);
            System.out.println(result);
            //是一个列表List
            JSONArray array = JSONArray.parseArray(result);


        }

        return result;
    }



}
