package com.exercies.es.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @ClassName: GoodsInfo
 * @Description: TODO indexName索引名称 数据库表名；type是类型 表名
 * @Author: Gavin
 * @Create: 2020-11-09 10:21
 * @Version: 1.0
 * @Copyright: 2018~2020-11-09 10:21 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
@AllArgsConstructor
@NoArgsConstructor
@Data

@Document(indexName = "contents",type = "content")
public class GoodsInfo implements Serializable {
    private static final long serialVersionUID = -5897143640140612702L;

    private Long id;
    private String name;
    private String des;

}
