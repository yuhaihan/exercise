package com.xiaoduomi.bean.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Data;

import java.io.Serializable;


/**
 * @ClassName: Img
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2020-09-27 16:39
 * @Version: 1.0
 * @Copyright: 2018~2020-09-27 16:39 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
@Data
@XStreamAlias("Img")
public class Img implements Serializable {
    private static final long serialVersionUID = 3253035929264296338L;

    @XStreamAlias("InputPath")
    private String InputPath;
    @XStreamAlias("RegionsOfInterest")
    private RegionsOfInterest RegionsOfInterest;


}
