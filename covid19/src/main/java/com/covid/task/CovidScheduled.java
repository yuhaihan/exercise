package com.covid.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.covid.service.BaiDuCovid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * @ClassName: CovidScheduled
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2022-03-26 18:12
 * @Version: 1.0
 * @Copyright: 2018~2022-03-26 18:12 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
@Slf4j
@Component
public class CovidScheduled {

    @Value("${covid.sum.path}")
    private String filepath;

    @Scheduled(cron = "0 0 1 * * ?")
    public void scheduled() throws Exception {
        // 廊坊疫情数据
        File file = new File(filepath);
        if (!file.getParentFile().exists()) {
            log.info("新建目录:{}",filepath);
            file.getParentFile().mkdirs();
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        JSONObject covid_lf = BaiDuCovid.getAreaStat();
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filepath),"UTF-8");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("domesticCase",covid_lf.get("confirmedRelative"));
        jsonObject.put("asymptomaticCase",covid_lf.get("asymptomaticRelative"));
        jsonObject.put("confirmedCase",covid_lf.get("curConfirm"));
        jsonObject.put("curedCase",covid_lf.get("crued"));
        jsonObject.put("deadCase",covid_lf.get("died"));
        osw.write(jsonObject.toString());
        osw.flush();//清空缓冲区，强制输出数据
        osw.close();//关闭输出流
    }

}
