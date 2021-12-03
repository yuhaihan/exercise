package com.design.pattern.factory.sample;

/**
 * @ClassName: Cat
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2021-12-03 08:50
 * @Version: 1.0
 */
public class Cat implements Zoo{
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
}
