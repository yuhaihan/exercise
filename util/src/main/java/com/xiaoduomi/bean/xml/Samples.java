package com.xiaoduomi.bean.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: Samples
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2020-09-27 16:27
 * @Version: 1.0
 * @Copyright: 2018~2020-09-27 16:27 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
@Data
@XStreamConverter(value = ToAttributedValueConverter.class, strings = {"Img"})
@XStreamAlias("Samples")
public class Samples implements Serializable {

    private static final long serialVersionUID = -2148000733373436004L;

    @XStreamImplicit
    private List<Img> Img;




}
