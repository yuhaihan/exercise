package com.design.pattern.factory.sample;

/**
 * @ClassName: Dog
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2021-12-03 08:50
 * @Version: 1.0
 */
public class Dog implements Zoo{

    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }
}
