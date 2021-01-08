package com.concurrent.study.day2;

import org.omg.CORBA.StringHolder;

/**
 * @ClassName: WaitMethod
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2020-10-28 09:47
 * @Version: 1.0
 * @Copyright: 2018~2020-10-28 09:47 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
public class WaitMethod {

    private static Object Shared_Variable = new Object();


    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("begin");
                synchronized (Shared_Variable){
                    try {
                        Shared_Variable.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("end");
            }


        });

        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("threand begin");
        thread.interrupt();
        System.out.println("threand end");


    }

}
