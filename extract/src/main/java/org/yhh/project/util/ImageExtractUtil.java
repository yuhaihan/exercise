package org.yhh.project.util;

import com.alibaba.fastjson.JSON;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.http.client.HttpClient;
import org.apache.logging.log4j.util.Base64Util;
import org.json.JSONObject;
import org.yhh.project.pojo.ImageResult;
import org.yhh.project.service.AuthService;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;

/**
 * @ClassName: ImageExtractUtil
 * @Author: Gavin
 * @Create: 2021-07-02 13:43
 * @Version: 1.0
 * @Copyright: 2018~2021-07-02 13:43 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
public class ImageExtractUtil {


    public static void main(String[] args) throws TesseractException {
        // //加载待读取图片
        // File imageFile = new File("C:\\Users\\yhhus\\Desktop\\悯农.jpg");
        // //创建tess对象
        // ITesseract instance = new Tesseract();
        // //设置训练文件目录
        // instance.setDatapath("C:\\Users\\yhhus\\Desktop\\tessdata");
        // //设置训练语言
        // instance.setLanguage("chi_sim");
        // //执行转换
        // String result = instance.doOCR(imageFile);
        // System.out.println(result);


        String accessToken = AuthService.getAuth();
        // 通用识别url
        String otherHost = "https://aip.baidubce.com/rest/2.0/ocr/v1/general_basic?access_token=" + accessToken;
        try {
            InputStream in;
            byte[] data = null;
            // 读取图片字节数组
            try {
                in = new FileInputStream("C:\\Users\\yhhus\\Desktop\\悯农.jpg");
                data = new byte[in.available()];
                in.read(data);
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 对字节数组Base64编码
            BASE64Encoder encoder = new BASE64Encoder();
            // 返回Base64编码过的字节数组字符串
            String imgStr = encoder.encode(data);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            //开始搭建post请求
            String result = HttpClientUtil.postJSON(otherHost, "image=" + imgParam);


            ImageResult imageResult1 = (ImageResult)JSON.parseObject(result, ImageResult.class);
            System.out.println(imageResult1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
