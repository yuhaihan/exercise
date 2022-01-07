package com.design.pattern.factory;

/**
 * @ClassName: StrategyFactoryTest
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2022-01-07 15:49
 * @Version: 1.0
 * @Copyright: 2018~2022-01-07 15:49 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
public class StrategyFactoryTest {

    public static void main(String[] args) {
        IStrategy iStrategy = new StrategyFactory().getName(1);
        System.out.println(iStrategy.getName());

        iStrategy = new StrategyFactory().getName(2);
        System.out.println(iStrategy.getName());
    }

}
