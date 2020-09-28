/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: XmlUtils
 * Author:   zhangzhe
 * Date:     2020/7/15 14:11
 * Description: 操作XML工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.xiaoduomi.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.*;

/**
 * 〈操作XML工具类  xml2bean  bean2xml〉
 *
 * @author zhangzhe
 * @create 2020/7/15
 * @since 1.0.0
 */
public class XmlUtils {
    public static XStream xStreamXml = new XStream(new DomDriver("UTF-8"));
    public static XStream xStreamJson = new XStream(new JsonHierarchicalStreamDriver());
    public static XStream xStreamJson2Bean =  new XStream(new JettisonMappedXmlDriver());

    static {
        XStream.setupDefaultSecurity(xStreamXml);
        XStream.setupDefaultSecurity(xStreamJson);
        XStream.setupDefaultSecurity(xStreamJson2Bean);
    }

    /**
     * bean类 写出 xml文件
     *
     * @param bean 要转换的bean
     * @param fileName  写出xml文件的地址  ：C:\Users\zhangzhe\Desktop\test.xml
     * @return  返回boolean
     */
    public static <T> boolean bean2xml(T bean, String fileName) {

        try {
            //设置XStream类型
            xStreamXml.allowTypes(new Class[]{bean.getClass()});
            //设置别名允许
            xStreamXml.processAnnotations(bean.getClass());
            //打开xml文件
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            xStreamXml.toXML(bean, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     *  xml字符串转bean
     *
     * @param beanClass     要转换的bean的类型  ：A.class
     * @param xmlStr   xml文件字符串
     * @return
     */
    public static Object xml2bean(Class beanClass, String xmlStr){
        //设置XStream类型
        xStreamXml.allowTypes(new Class[]{beanClass});
        //设置别名允许
        xStreamXml.processAnnotations(beanClass);
        try {
            return xStreamXml.fromXML(xmlStr);
        }catch (Exception e){
            return false;
        }
    }

    /**
     *  xml文件转bean
     * @param beanClass     要转换的bean的类型  ：A.class
     * @param fileName   要读取的xml文件的地址  ：C:\Users\zhangzhe\Desktop\test.xml
     * @return
     */
    public static Object xmlFile2bean(Class beanClass, String fileName){
        try {
            //打开xml文件
            File xmlFile = new File(fileName);
            //读取xml文件到StringBuffer
            InputStream in = new FileInputStream(xmlFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(in,"utf-8"));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = br.readLine()) !=null) {
                buffer.append(line);
            }
            br.close();
            //转换为bean对象
            return xml2bean(beanClass,buffer.toString());
        }catch (Exception e) {
            return null;
        }
    }

    public static Object json2bean(String aliasName,Class classType,String jsonStr){
        xStreamJson2Bean.addPermission(AnyTypePermission.ANY);
        xStreamJson2Bean.alias(aliasName,classType);
        return xStreamJson2Bean.fromXML(jsonStr);
    }

    public static String bean2json(String aliasName,Class classType,Object bean){
        xStreamJson.alias(aliasName,classType);
        xStreamJson.setMode(XStream.NO_REFERENCES);
        return xStreamJson.toXML(bean);
    }
}
