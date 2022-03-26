package com.covid.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xiaoduomi.fastjson.FastJsonUtils;
import com.xiaoduomi.http.HttpClientUtil;
import org.springframework.aop.scope.ScopedProxyUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: BaiDuCovid
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2022-03-26 15:45
 * @Version: 1.0
 * @Copyright: 2018~2022-03-26 15:45 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
public class BaiDuCovid {

    private final static String baiduUrl = "https://voice.baidu.com/act/newpneumonia/newpneumonia";


    /**
     * 廊坊疫情数据
     */
    public static JSONObject getAreaStat() {
        Map<String, String> headMap = new HashMap<>();
        String baiduResult = HttpClientUtil.doGetRequestNoparam(baiduUrl, headMap);

        String reg = "captain-config\">(.*?)\\<(?=/script>)";
        Pattern totalPattern = Pattern.compile(reg);
        Matcher totalMatcher = totalPattern.matcher(baiduResult);

        String result = "";
        if (totalMatcher.find()) {
            result = totalMatcher.group(1);
            //各个省市的是一个列表List
            JSONObject jsonObject = (JSONObject) JSONObject.parse(result);
            JSONArray component = (JSONArray) jsonObject.get("component");
            for (int k = 0; k < component.size(); k++) {

                JSONArray caseList = (JSONArray) component.getJSONObject(k).get("caseList");
                for (int i = 0; i < caseList.size(); i++) {
                    String area = (String) caseList.getJSONObject(i).get("area");
                    if (area.equals("河北")) {

                        JSONArray subList = (JSONArray) caseList.getJSONObject(i).get("subList");

                        for (int j = 0; j < subList.size(); j++) {
                            String city = (String) subList.getJSONObject(j).get("city");
                            if (city.equals("廊坊")) {
                                JSONObject city_lf = subList.getJSONObject(j);
                                return city_lf;
                                //String confirmedRelative = (String)city_lf.get("confirmedRelative");
                                //System.out.println("新增确诊"+confirmedRelative);
                                //
                                //String asymptomaticRelative = (String)city_lf.get("asymptomaticRelative");
                                //System.out.println("新增无症状"+asymptomaticRelative);
                                //
                                //String curConfirm = (String)city_lf.get("curConfirm");
                                //System.out.println("现有确诊"+curConfirm);
                                //
                                //String crued = (String)city_lf.get("crued");
                                //System.out.println("累计治愈"+crued);
                                //
                                //String died = (String)city_lf.get("died");
                                //System.out.println("累计死亡"+died);

                            }
                        }
                    }

                }
            }
        }


        return null;

    }

}
