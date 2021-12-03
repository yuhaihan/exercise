package com.design.pattern.factory.sample;

/**
 * @ClassName: Breeder
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2021-12-03 08:59
 * @Version: 1.0
 */
public class Breeder {

    public static void main(String[] args) {
        Zoo dog = ZooFactory.eat("dog");
        dog.eat();
    }
}
