package org.yhh.project.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: ImageResult
 * @Author: Gavin
 * @Create: 2021-07-02 17:30
 * @Version: 1.0
 * @Copyright: 2018~2021-07-02 17:30 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
public class ImageResult implements Serializable {

    private static final long serialVersionUID = 8685265303867269520L;
    private List<Words_result> words_result;
    private long log_id;
    private int words_result_num;

    public void setWords_result(List<Words_result> words_result) {
        this.words_result = words_result;
    }

    public List<Words_result> getWords_result() {
        return words_result;
    }

    public void setLog_id(long log_id) {
        this.log_id = log_id;
    }

    public long getLog_id() {
        return log_id;
    }

    public void setWords_result_num(int words_result_num) {
        this.words_result_num = words_result_num;
    }

    public int getWords_result_num() {
        return words_result_num;
    }


}
