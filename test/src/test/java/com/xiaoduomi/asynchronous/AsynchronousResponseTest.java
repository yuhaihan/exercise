package com.xiaoduomi.asynchronous;

import javafx.scene.media.VideoTrack;
import org.junit.Test;
import org.omg.CORBA.StringHolder;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @ClassName: AsynchronousResponseTest
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2020-09-29 10:29
 * @Version: 1.0
 * @Copyright: 2018~2020-09-29 10:29 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
public class AsynchronousResponseTest {


    //创建线程池
    private static ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

    @Test
    public void testAsynchronousResponse(){
        String s = "hi yu";
        executor.execute(new ToServer(s));
        System.out.println("s"+"ssss---");

    }

    class ToServer extends Thread{
        private String s;

        public ToServer(String s){
            this.s = s;
        }

        @Override
        public void run(){
            System.out.println(s);
        }

    }
}
