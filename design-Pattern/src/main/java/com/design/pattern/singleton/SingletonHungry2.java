package com.design.pattern.singleton;

/**
 * @ClassName: SingtonLazy
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2020-09-15 14:59
 * @Version: 1.0
 * @Copyright: 2018~2020-09-15 14:59 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
public class SingletonHungry2 {

    private static SingletonHungry2 singletonHungry2 = null;

    static {
        singletonHungry2 = new SingletonHungry2();
    }
    private SingletonHungry2(){}

    public static SingletonHungry2 getInstance(){
        return singletonHungry2;
    }

}
