package com.xiaoduomi.http;

import lombok.Data;

import java.io.Serializable;
import java.util.Vector;

/**
 * @ClassName: Serie
 * @Author: Gavin
 * @Create: 2022-01-10 15:51
 * @Version: 1.0
 * @Copyright: 2018~2022-01-10 15:51 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
@Data
public class Serie implements Serializable {
    private static final long serialVersionUID = -4374166589216715270L;

    // 名字
    private String name;
    // 数据值ֵ
    private Vector<Object> data;

    /**
     * @param name  名称（线条名称）
     * @param array 数据（线条上的所有数据值）
     */
    public Serie(String name, Object[] array) {
        this.name = name;
        if (array != null) {
            data = new Vector<Object>(array.length);
            for (int i = 0; i < array.length; i++) {
                data.add(array[i]);
            }
        }
    }


}
