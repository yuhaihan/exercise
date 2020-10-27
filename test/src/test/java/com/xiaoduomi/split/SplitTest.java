package com.xiaoduomi.split;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: SplitTest
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2020-09-29 10:38
 * @Version: 1.0
 * @Copyright: 2018~2020-09-29 10:38 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
public class SplitTest {


    @Test
    public void testSplit(){
        String selectedData = "GF1_PMS2_E69.8_N23.8_20200922_L1A0005079665.tar.gz";
        List<String> list = Arrays.asList(selectedData.split(","));
        System.out.println(list);

    }
}
