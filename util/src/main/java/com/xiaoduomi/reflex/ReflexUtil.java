package com.xiaoduomi.reflex;

import lombok.Data;

import java.lang.reflect.Field;

/**
 * @ClassName: ReflexUtil
 * @Description:
 * @Author: Gavin
 * @Create: 2022-01-18 15:47
 * @Version: 1.0
 * @Copyright: 2018~2022-01-18 15:47 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
public class ReflexUtil {


    public static void main(String[] args) throws IllegalAccessException {
        User user = new User();
        user.setId(1);
        user.setUsername("yu");
        user.setPrice(1.1);
        attributeExistNull(user);
    }


    public static void attributeExistNull(User user) throws IllegalAccessException {
        Class<? extends User> clazz = user.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field f = fields[i];
            f.setAccessible(true);
            System.out.println("属性名:" + f.getName() + " 属性值:" + f.get(user));
            System.out.println("属性名:" + f.getName() + " 属性值:" + f.get(user));
            Object o = f.get(user);
        }
    }


    @Data
    static class User{
        private Integer id;

        private String username;

        private double price;
    }

}
