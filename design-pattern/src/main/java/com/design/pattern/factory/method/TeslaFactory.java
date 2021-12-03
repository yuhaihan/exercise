package com.design.pattern.factory.method;

/**
 * @ClassName: TeslaFactory
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2021-12-03 09:14
 * @Version: 1.0
 */
public class TeslaFactory implements CarFactory{
    @Override
    public Car getCar() {
        return new Tesla();
    }
}
