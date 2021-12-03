package com.design.pattern.factory.method;

/**
 * @ClassName: Tesla
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2021-12-03 09:10
 * @Version: 1.0
 */
public class Tesla implements Car{

    @Override
    public void name() {
        System.out.println("特斯拉");
    }
}
