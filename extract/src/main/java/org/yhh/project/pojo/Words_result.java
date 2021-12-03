package org.yhh.project.pojo;

import java.io.Serializable;

/**
 * @ClassName: Words_result
 * @Author: Gavin
 * @Create: 2021-07-02 17:38
 * @Version: 1.0
 * @Copyright: 2018~2021-07-02 17:38 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
public class Words_result implements Serializable {
    private static final long serialVersionUID = -6995896462819185778L;
    private String words;

    public void setWords(String words) {
        this.words = words;
    }
    public String getWords() {
        return words;
    }

}
