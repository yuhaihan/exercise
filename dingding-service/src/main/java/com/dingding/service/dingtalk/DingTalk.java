package com.dingding.service.dingtalk;

import com.alibaba.fastjson.JSONObject;
import com.xiaoduomi.http.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Objects;

/**
 * @ClassName: DingTalk
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2022-03-02 14:45
 * @Version: 1.0
 * @Copyright: 2018~2022-03-02 14:45 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
@Slf4j
public class DingTalk {

    /** url token */
    private static final String dingDingToken = "https://oapi.dingtalk.com/robot/send?access_token=3480a6ef3d3c5a610259a5d79402362a98ebfbd0e489833c3d833e31bf243146";
    /** 签名 */
    private static final String secret = "SEC27abb37628b04b9b2f280c0b5a3a30ce3547b636d9150d0eaa583f70b631e703";

    private static DingTalk dingTalk;

    public DingTalk() {
    }

    public static DingTalk instance() {
        if (Objects.isNull(dingTalk)) {
            dingTalk = new DingTalk();
        }
        return dingTalk;
    }

    //public static void main(String[] args) {
    //    RuntimeException exception = new RuntimeException("测试异常");
    //    sendErrorTextMsg("测试钉钉群消息功能点", "10086", exception);
    //}


    /**
     * 钉钉群通知 （text类型 关键字:警告 ）
     * todo 可增加 拓展，暂时使用text格式
     * @param functionName 功能名称
     * @param userId       用户id
     * @param e            报警信息
     */
    public static void sendErrorTextMsg(String functionName, String userId, Exception e) {
        JSONObject request = buildRequest(functionName, userId, e);
        String url = dingDingToken + "&timestamp=" + System.currentTimeMillis() + "&sign=" + sign(secret);
        String response = HttpClientUtil.postJSON(url, request.toJSONString());
        System.out.println(response);
    }

    /**
     * 构建请求体
     *
     * @param functionName
     * @param userId
     * @param e
     * @return
     */
    private static JSONObject buildRequest(String functionName, String userId, Exception e) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msgtype", "text");
        JSONObject text = new JSONObject();
        String content = "用户：" + userId + ", " + functionName + "异常, 请及时解决\r\n" + "" + e;
        text.put("content", content);
        jsonObject.put("text", text);
        JSONObject at = new JSONObject();
        at.put("isAtAll", true);
        jsonObject.put("at", at);
        return jsonObject;
    }


    private static String sign(String secret){
        String sign = null;
        try {
            Long timestamp = System.currentTimeMillis();

            String stringToSign = timestamp + "\n" + secret;
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
            byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
            sign = new String(Base64.encodeBase64(signData));
        }catch (Exception e){
            log.error("dingding talk sign error");
        }
        return sign;
    }


}
