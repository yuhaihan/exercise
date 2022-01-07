package com.example.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

/**
 * @ClassName: JDBCUtils
 * @Author: Gavin
 * @Create: 2021-12-24 23:21
 * @Version: 1.0
 * @Copyright: 2018~2021-12-24 23:21 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
public class JDBCUtils {

    /**
     * 注意！  此处数据源配置driver、url因mysql版本区别 而不相同
     */
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://121.36.66.217:3306/test_wws";
    private static String username = "root";
    private static String password = "KSHServer@2020";

    /**
     * 获得数据库连接
     *
     * @return
     */
    public static Connection getConnection() throws Exception {
        Class.forName(driver);
        System.out.println("数据库驱动加载成功");
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("数据库已连接");
        return connection;
    }

    /**
     * 获得数据库连接
     *
     * @return
     */
    public static void closeConnection(Connection connection)throws  Exception {
        if (Objects.nonNull(connection)) {
                connection.close();
                System.out.println("数据库连接已关闭");
        }
    }


}
