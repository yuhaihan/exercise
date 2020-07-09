package com.yu.hai.han.exercise.fastdfs.web;

import com.yu.hai.han.exercise.fastdfs.FastDFSClient;
import com.yu.hai.han.exercise.fastdfs.FastDFSException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: FastDFSController
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2020-07-09 14:28
 * @Version: 1.0
 * @Copyright: 2018~2020-07-09 14:28 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
@Controller
@RequestMapping(value = "/controller")
public class FastDFSController {


    @PostMapping(value = "/file")
    public void upload(MultipartFile file){
        try {
            String filePath = FastDFSClient.uploadFileWithMultipart(file);
            System.out.println(filePath);
        } catch (FastDFSException e) {
            e.printStackTrace();
        }

    }

    @GetMapping(value = "/dowoload")
    public void dowoload(HttpServletResponse response){
        try {
            FastDFSClient.downloadFile("group1/M00/00/00/wKgAPl8GvSmAXdryAAOIHUkqgqI926.jpg",response);
        } catch (FastDFSException e) {
            e.printStackTrace();
        }

    }

    @PutMapping(value = "/file")
    public void dowoload(){
        try {
            int i = FastDFSClient.deleteFile("group1/M00/00/00/wKgAPl8GvSmAXdryAAOIHUkqgqI926.jpg");
        } catch (FastDFSException e) {
            e.printStackTrace();
        }

    }


}
