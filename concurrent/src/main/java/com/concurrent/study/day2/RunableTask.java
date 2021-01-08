package com.concurrent.study.day2;

/**
 * @ClassName: RunableTask
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2020-10-28 08:45
 * @Version: 1.0
 * @Copyright: 2018~2020-10-28 08:45 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
public class RunableTask implements Runnable{

    @Override
    public void run() {
        System.out.println("启动RunableTask线程");
    }

    public static void main(String[] args) {
        RunableTask runableTask = new RunableTask();
        new Thread(runableTask).start();

        System.out.println("");
    }
}
