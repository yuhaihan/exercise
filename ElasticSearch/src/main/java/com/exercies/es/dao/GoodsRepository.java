package com.exercies.es.dao;

import com.exercies.es.entity.GoodsInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @ClassName: GoodsRepository
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2020-11-09 10:26
 * @Version: 1.0
 * @Copyright: 2018~2020-11-09 10:26 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
@Component
public interface GoodsRepository extends ElasticsearchRepository<GoodsInfo,Long> {


}
