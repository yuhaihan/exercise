package com.xiaoduomi.http;

/**
 * @ClassName: Test
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2020-09-09 08:26
 * @Version: 1.0
 * @Copyright: 2018~2020-09-09 08:26 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
public class Test {

    public static void main(String[] args) {
        int i;
        int j;
        for (i = 0; i < 5; i++) {
            for (j = 1; j < 10; j++)
                if (j == 6) {
                    break;
                }
                if (i < 3) {
                    continue;
                }
                if (i > 3) {
                    break;

            }
            System.out.printf("i=%d,j=%d\n", i, j);
        }

    }

}
