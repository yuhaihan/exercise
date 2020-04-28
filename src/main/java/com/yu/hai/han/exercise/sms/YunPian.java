package com.yu.hai.han.exercise.sms;

import com.yu.hai.han.exercise.utils.HttpClientUtil;
import com.yu.hai.han.exercise.utils.UUIDUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Gavin
 * @create: 2020-04-27 17:13
 * @Copyright: 2018~2020-04-27 17:13 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
@Slf4j
public class YunPian {

    // 云片 apikey
    private final static String APIKEY = "02e551d2532e2fb4d014f1d0a2752bd6";
    // 短信内容
    private final static String MOBILE_TEXT="#code#";
    // 模板id
    private final static long TEL_ID = 3690484;
    // 手机号码
    private final static String MOBILE = "15512810623";
    // 查账户信息的http地址
    private static String URI_GET_USER_INFO = "https://sms.yunpian.com/v2/user/get.json";

    // 智能匹配模板发送接口的http地址
    private static String URI_SEND_SMS = "https://sms.yunpian.com/v2/sms/single_send.json";

    // 模板发送接口的http地址
    private static String URI_TPL_SEND_SMS = "https://sms.yunpian.com/v2/sms/tpl_single_send.json";

    // 发送语音验证码接口的http地址
    private static String URI_SEND_VOICE = "https://voice.yunpian.com/v2/voice/send.json";

    // 绑定主叫、被叫关系的接口http地址
    private static String URI_SEND_BIND = "https://call.yunpian.com/v2/call/bind.json";

    // 解绑主叫、被叫关系的接口http地址
    private static String URI_SEND_UNBIND = "https://call.yunpian.com/v2/call/unbind.json";

    // 编码格式。发送编码格式统一用UTF-8
    private static String ENCODING = "UTF-8";


//    public static void main(String[] args) {
//        try {
//            getUserInfo();
//            tplSendSms(APIKEY,TEL_ID,URLEncoder.encode(MOBILE_TEXT, ENCODING) + "=" + URLEncoder.encode(UUIDUtils.sixRandomNumber(), ENCODING),MOBILE);
//
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//    }

    /**
     * 通过云片apikey,获取用户信息
     *
     * @return
     * @throws IOException
     * @throws URISyntaxException
     */
    public static String getUserInfo() throws IOException, URISyntaxException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("apikey", APIKEY);
        String result = HttpClientUtil.post(URI_GET_USER_INFO, params);
        return result;
    }

    /**
     * 通过模板发送短信(不推荐)
     *
     * @return
     * @throws IOException
     * @throws URISyntaxException
     */
    public static String tplSendSms(String apikey, long tpl_id, String tpl_value, String mobile) throws IOException, URISyntaxException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("apikey", apikey);
        params.put("tpl_id", String.valueOf(tpl_id));
        params.put("tpl_value", tpl_value);
        params.put("mobile", mobile);
        String result = HttpClientUtil.post(URI_TPL_SEND_SMS, params);
        return result;
    }


    /**
     * 通过接口发送语音验证码
     *
     * @param apikey apikey
     * @param mobile 接收的手机号
     * @param code   验证码
     * @return
     */

    public static String sendVoice(String apikey, String mobile, String code) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("apikey", apikey);
        params.put("mobile", mobile);
        params.put("code", code);
        return HttpClientUtil.post(URI_SEND_VOICE, params);
    }

    /**
     * 通过接口绑定主被叫号码
     * @param apikey apikey
     * @param from 主叫
     * @param to   被叫
     * @param duration 有效时长，单位：秒
     * @return public static String bindCall(String apikey, String from, String to,
    Integer duration) {
    Map < String, String > params = new HashMap < String, String > ();
    params.put("apikey", apikey);
    params.put("from", from);
    params.put("to", to);
    params.put("duration", String.valueOf(duration));
    return post(URI_SEND_BIND, params);
    }


     * 通过接口解绑绑定主被叫号码
     * @param apikey apikey
     * @param from 主叫
     * @param to   被叫
     * @return public static String unbindCall(String apikey, String from, String to) {
    Map < String, String > params = new HashMap < String, String > ();
    params.put("apikey", apikey);
    params.put("from", from);
    params.put("to", to);
    return post(URI_SEND_UNBIND, params);
    }
     */

}