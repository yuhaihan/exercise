package com.yu.hai.han.exercise.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @description: UUID工具类
 * @author: Gavin
 * @create: 2019-11-25 10:49
 * @Copyright: 2018~2019-11-25 10:49 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
@SuppressWarnings("all")
@Slf4j
public class UUIDUtils {

    public final static String TERMINAL_APP = "APP";


    /**
     * 生成用户唯一ID
     * 规则：终端类型（名称） + 年月日时分秒 + 六位随机数
     * KnowNow20191125113324615322
     *
     * @return
     */
    public static String generateUserId(String terminal) {
        return
                terminal
                        + currentTimeStr()
                        + sixRandomNumber();

    }

    /**
     * 生成六位随机数
     * @return
     */
    public static String sixRandomNumber() {
        StringBuilder str = new StringBuilder();
        try {
            Random random = new Random();
            for (int i = 0; i < 6; i++) {
                str.append(random.nextInt(10));
            }
        } catch (Exception e) {
            log.warn("生成随机数异常:[{}]", e.getMessage());
        }
        return str.toString();
    }

    /**
     * 生成随机数 (32位UUID)
     * @param number
     * @return
     */
    public static String uuidNumber() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "");
    }


    /**
     * 获取当前时间字符串年月日时分秒
     * 格式：20191125114440
     * @return
     */
    private static String currentTimeStr() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(d);
    }

}
