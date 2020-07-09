package com.yu.hai.han.exercise.fastdfs;

/**
 * @ClassName: ErrorCode
 * @Author: Gavin
 * @Create: 2020-07-09 13:59
 * @Version: 1.0
 * @Copyright: 2018~2020-07-09 13:59 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
public enum ErrorCode {
    FILE_PATH_ISNULL("error.fastdfs.file_path_isnull", "文件路径为空"),

    FILE_ISNULL("error.fastdfs.file_isnull", "文件为空"),

    FILE_UPLOAD_FAILED("error.fastdfs.file_upload_failed", "文件上传失败"),

    FILE_NOT_EXIST("error.fastdfs.file_not_exist", "文件不存在"),

    FILE_DOWNLOAD_FAILED("error.fastdfs.file_download_failed", "文件下载失败"),

    FILE_DELETE_FAILED("error.fastdfs.file_delete_failed", "删除文件失败"),

    FILE_SERVER_CONNECTION_FAILED("error.fastdfs.file_server_connection_failed", "文件服务器连接失败"),

    FILE_OUT_SIZE("error.fastdfs.file_server_connection_failed", "文件超过大小"),

    FILE_TYPE_ERROR_IMAGE("error.file.type.image", "图片类型错误"),

    FILE_TYPE_ERROR_DOC("error.file.type.doc", "文档类型错误"),

    FILE_TYPE_ERROR_VIDEO("error.file.type.video", "音频类型错误"),

    FILE_TYPE_ERROR_COMPRESS("error.file.type.compress", "压缩文件类型错误");


    public String CODE;

    public String MESSAGE;

    ErrorCode(String CODE, String MESSAGE){
        this.CODE = CODE;
        this.MESSAGE = MESSAGE;
    }

}
