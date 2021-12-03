package com.design.pattern.factory.sample;

/**
 * @ClassName: ZooFactory
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2021-12-03 08:53
 * @Version: 1.0
 */
public class ZooFactory {

    public static Zoo eat(String type){
        if ("dog".equals(type)) {
            return new Dog();
        } else if ("cat".equals(type)) {
            return new Cat();
        }else{
            return null;
        }
    }

}
