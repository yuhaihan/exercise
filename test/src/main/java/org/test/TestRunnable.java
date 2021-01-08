package org.test;

/**
 * @ClassName: TestRunnable
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2020-12-16 14:12
 * @Version: 1.0
 * @Copyright: 2018~2020-12-16 14:12 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
public class TestRunnable {

    public static void main(String[] args) {

        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                System.out.println("创建事件");
            }
        };

        Runnable runnable1 = ()-> System.out.println("匿名函数");

        Thread thread1 = new Thread(()->System.out.println("匿名函数"), "线程");
        thread1.start();


        Thread thread = new Thread(runnable,"线程1");
        thread.start();


        System.out.println("测试code review");


    }

}
