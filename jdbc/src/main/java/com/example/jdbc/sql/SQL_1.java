package com.example.jdbc.sql;

import com.example.jdbc.util.JDBCUtils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;

/**
 * @ClassName: SQL_1
 * @Author: Gavin
 * @Create: 2021-12-24 23:31
 * @Version: 1.0
 * @Copyright: 2018~2021-12-24 23:31 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
public class SQL_1 {


    public static void execProcedure(String startTime,String endTime){
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;

        try {
            // 连接数据库
            connection = JDBCUtils.getConnection();

            if (Objects.isNull(connection)) {
                System.out.println("数据库连接异常");
                return;
            }
            // 此处调用存储过程
            // 1、创建CallableStatement对象 2、调用存储过程（存储过程名称：wws_StatisticalSubTime ）
            callableStatement = connection.prepareCall("call wws_StatisticalSubTime(?,?)");
            callableStatement.setString(1, startTime); // 设置存储过程的第一个参数
            callableStatement.setString(2, endTime); // 设置存储过程的第一个参数

            // 执行调用存储过程，并获取结果集
            resultSet = callableStatement.executeQuery();
            ArrayList<LinkedHashMap<String, Object>> list = new ArrayList<>();
            // 读取数据
            while (resultSet.next()){
                LinkedHashMap<String, Object> hashMap = new LinkedHashMap<>();
                String teacherId = resultSet.getString("老师id");
                hashMap.put("老师id",teacherId);
                String subject = resultSet.getString("学科");
                hashMap.put("学科",subject);
                String hours = resultSet.getString("课时长(单位：小时)");
                hashMap.put("课时长(单位：小时)",hours);
                String minute = resultSet.getString("课时长(单位：分钟)");
                hashMap.put("课时长(单位：分钟)",minute);
                String second = resultSet.getString("课时长(单位：秒)");
                hashMap.put("课时长(单位：秒)",second);
                list.add(hashMap);
            }

            // 结果输出
            System.out.println(list);

        }catch (Exception e){
            System.out.println("执行存储过程异常：");
            e.printStackTrace();
        }finally {
            try {
                JDBCUtils.closeConnection(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


    /**
     * 测试启动
     * @param args
     */
    public static void main(String[] args) {
        execProcedure("20211222","20211229");
    }

}
