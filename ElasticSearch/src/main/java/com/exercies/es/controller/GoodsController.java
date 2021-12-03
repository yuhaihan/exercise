package com.exercies.es.controller;

import com.exercies.es.dao.GoodsRepository;
import com.exercies.es.entity.GoodsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: GoodsController
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2020-11-09 10:45
 * @Version: 1.0
 * @Copyright: 2018~2020-11-09 10:45 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
@RestController
public class GoodsController {

    @Autowired
    private GoodsRepository goodsRepository;

    @GetMapping("save")
    public String save(String des){
        GoodsInfo goodsInfo = new GoodsInfo(System.currentTimeMillis(),
                "商品"+System.currentTimeMillis(),des);
        goodsRepository.save(goodsInfo);
        return "success";
    }

    //http://localhost:8080/delete?id=
    @GetMapping("delete")
    public String delete(long id){
        goodsRepository.deleteById(id);
        return "success";
    }

    //http://localhost:8080/update?name=修改&des=修改&id=
    @GetMapping("update")
    public String update(long id,String name,String description){
        GoodsInfo goodsInfo = new GoodsInfo(id,
                name,description);
        goodsRepository.save(goodsInfo);
        return "success";
    }

    //http://localhost:8080/getOne?id=
    @GetMapping("getOne")
    public GoodsInfo getOne(long id){
        GoodsInfo goodsInfo = goodsRepository.findById(id).orElse(null);
        return goodsInfo;
    }


}
