package com.design.pattern.factory.method;

/**
 * @ClassName: Consumer
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2021-12-03 09:11
 * @Version: 1.0
 */
public class Consumer {

    public static void main(String[] args) {
        Car car = new WuLingFactory().getCar();
        Car car1 = new TeslaFactory().getCar();

        car.name();
        car1.name();

    }

}
