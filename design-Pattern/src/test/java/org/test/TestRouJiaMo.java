package org.test;

import com.design.pattern.factory.Factory;
import com.design.pattern.factory.Gift;
import com.design.pattern.factory.IFactoryA;
import com.design.pattern.factory.Product;
import org.junit.Test;

/**
 * @ClassName: TestRouJiaMo
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2020-09-14 17:37
 * @Version: 1.0
 * @Copyright: 2018~2020-09-14 17:37 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
public class TestRouJiaMo {

    @Test
    public void testJianDanFactory(){
        Factory factory = new Factory();
        Product product = factory.createProduct("A");
        System.out.println(product.price()+"-----"+product.name());
    }

    @Test
    public void testFactory(){
        IFactoryA iFactoryA = new IFactoryA();
        Product product = iFactoryA.createProduct();
        Gift gift = iFactoryA.createGift();
        System.out.println(product.price()+"-----"+product.name()+"-----"+gift.getGiftName());
    }




}
