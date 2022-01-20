package org.exercise.middleware.fastdfs;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: FastDFSFile
 * @Description: FastDFSFile
 * @Author: Gavin
 * @Create: 2020-07-09 12:48
 * @Version: 1.0
 * @Copyright: 2018~2020-07-09 12:48 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
@Data
public class FastDFSFile implements Serializable {

    private static final long serialVersionUID = 6207933939619977507L;

    private String name;
    private byte[] content;
    private String ext;
    private String md5;
    private String author;




}
