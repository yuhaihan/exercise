package com.design.pattern.factory;

/**
 * @ClassName: StrategyFactory
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2022-01-07 15:46
 * @Version: 1.0
 * @Copyright: 2018~2022-01-07 15:46 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
public class StrategyFactory {



    public IStrategy getName(Integer type){
        IStrategy iStrategy = null;
        if (type == 1) {
            iStrategy = new A1Strategy();
        } else if (type == 2) {
            iStrategy = new A2Strategy();
        }
        return iStrategy;
    }

}
