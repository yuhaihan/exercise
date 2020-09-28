package com.xiaoduomi.bean.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName: Polygon
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2020-09-27 18:08
 * @Version: 1.0
 * @Copyright: 2018~2020-09-27 18:08 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XStreamConverter(value = ToAttributedValueConverter.class, strings = {"polygon"})
@XStreamAlias("Polygon")
public class Polygon implements Serializable {
    private static final long serialVersionUID = 4216895638770719141L;
    private String polygon ;
}
