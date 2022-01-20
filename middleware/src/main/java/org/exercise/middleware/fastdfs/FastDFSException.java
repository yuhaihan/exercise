package org.exercise.middleware.fastdfs;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: FastDFSException
 * @Description: FastDFS 上传下载时可能出现的一些异常信息
 * @Author: Gavin
 * @Create: 2020-07-09 13:54
 * @Version: 1.0
 * @Copyright: 2018~2020-07-09 13:54 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
@Data
public class FastDFSException extends Exception implements Serializable {

    private static final long serialVersionUID = 4185465988646196325L;
    /**
     * 错误码
     */
    private String code;

    /**
     * 错误消息
     */
    private String message;

    public FastDFSException(String code, String message) {

    }
}
