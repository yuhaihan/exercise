package com.concurrent.study.day2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName: CallerTask
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2020-10-28 08:51
 * @Version: 1.0
 * @Copyright: 2018~2020-10-28 08:51 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
public class CallerTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("线程启动");
        return "hello";
    }

    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(new CallerTask());
        // 启动线程
        new Thread(futureTask).start();

        try {
            String s = futureTask.get();

            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
