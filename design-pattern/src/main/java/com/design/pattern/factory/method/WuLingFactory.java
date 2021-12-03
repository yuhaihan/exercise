package com.design.pattern.factory.method;

/**
 * @ClassName: WuLingFactory
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2021-12-03 09:14
 * @Version: 1.0
 */
public class WuLingFactory implements CarFactory{

    @Override
    public Car getCar() {
        return new WuLing();
    }
}
