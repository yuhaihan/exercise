package com.yu.hai.han.exercise.fastdfs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;

/**
 * @ClassName: FileResponseData
 * @Description: 上传文件后的数据返回对象，便于前台获取数据.
 * @Author: Gavin
 * @Create: 2020-07-09 14:02
 * @Version: 1.0
 * @Copyright: 2018~2020-07-09 14:02 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
public class FileResponseData implements Serializable {

    private static final long serialVersionUID = -7379137617904574901L;
    /**
     * 返回状态编码
     */
    @JsonInclude(Include.NON_NULL)
    private String code;

    /**
     * 返回信息
     */
    @JsonInclude(Include.NON_NULL)
    private String message;

    /**
     * 成功标识
     */
    private boolean success = true;

    /**
     * 文件路径
     */
    @JsonInclude(Include.NON_NULL)
    private String filePath;

    /**
     * 文件名称
     */
    @JsonInclude(Include.NON_NULL)
    private String fileName;

    /**
     * 文件类型
     */
    @JsonInclude(Include.NON_NULL)
    private String fileType;

    /**
     * Http URL
     */
    @JsonInclude(Include.NON_NULL)
    private String httpUrl;

    /**
     * Http Token
     */
    @JsonInclude(Include.NON_NULL)
    private String token;


}
