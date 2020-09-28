package com.xiaoduomi.bean.xml;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName: Test
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2020-09-27 17:36
 * @Version: 1.0
 * @Copyright: 2018~2020-09-27 17:36 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestXml implements Serializable {

    private static final long serialVersionUID = -6989253980169271076L;
    private Samples Samples;

}
