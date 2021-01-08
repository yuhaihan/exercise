package com.concurrent.study.day1;

import java.sql.SQLOutput;

/**
 * @ClassName: ThreadTest
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2020-10-27 22:27
 * @Version: 1.0
 * @Copyright: 2018~2020-10-27 22:27 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
public class ThreadTest {

    /**
     * 集成Thread类 重写run方法。
     */
    public static class ThreadClass extends Thread{
        @Override
        public void run() {
            System.out.println("----》执行了ThreadClass线程类的run方法");
        }

        public ThreadClass(){
            System.out.println("创建ThreadClass类");
        }

    }

    /**
     * 创建线程类ThreadClass，首先执行空参构造函数 打印“创建ThreadClass类。如果不执行threadClass线程的start()方方，该线程不会执行。
     * @param args
     */
    public static void main(String[] args) {
        // 创建线程
        ThreadClass threadClass = new ThreadClass();
        // 启动线程
        threadClass.start();
    }
}
