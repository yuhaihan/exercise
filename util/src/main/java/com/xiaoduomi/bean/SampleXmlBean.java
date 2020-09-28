/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: SampleXmlBean
 * Author:   zhangzhe
 * Date:     2020/8/11 20:04
 * Description: 样本点xml实体类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.xiaoduomi.bean;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈样本点xml实体类〉
 *
 * @author zhangzhe
 * @create 2020/8/11
 * @since 1.0.0
 */
@Data  //lombok方法
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("Samples")
public class SampleXmlBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @XStreamAlias("GeometryDef")
    private GeometryDef geometryDef;

    @XStreamAlias("RegionsOfInterest")
    private RegionsOfInterest regionsOfInterest;

    /**
     *  <Samples><Samples/> 中的  GeometryDef
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GeometryDef implements Serializable {
        private static final long serialVersionUID = 1L;
        private String CoordSysStr = "GEOGCS[\"GCS_WGS_1984\",DATUM[\"D_WGS_1984\",SPHEROID[\"WGS_1984\",6378137.0,298.257223563]],PRIMEM[\"Greenwich\",0.0],UNIT[\"Degree\",0.0174532925199433]]";
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @XStreamConverter(value = ToAttributedValueConverter.class, strings = {"regions"})
    public static class RegionsOfInterest implements Serializable {
        private static final long serialVersionUID = 1L;

        @XStreamImplicit
        private List<Region> regions;
    }
    /**
     * <Region><Region/>
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @XStreamAlias("Region")
    @XStreamConverter(value = ToAttributedValueConverter.class, strings = {"polygons"})
    public static class Region implements Serializable {
        private static final long serialVersionUID = 1L;
        @XStreamAsAttribute
        private String name = "河流";
        @XStreamAsAttribute
        private String color = "255,0,0";

        @XStreamImplicit
        private List<Polygon> polygons;
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @XStreamConverter(value = ToAttributedValueConverter.class, strings = {"polygon"})
    @XStreamAlias("Polygon")
    public static class Polygon implements Serializable {
        private static final long serialVersionUID = 1L;
        private String polygon = "./input.tif";
    }

    /**
     *  将 JSONObjct 字符串转换为 SampleXmlBean 实体类
     * @param jsonObject SampleXmlBean 实体类转换的 json字符串
     * @return
     */
    public static SampleXmlBean jsonStr2SampleXmlBean(JSONObject jsonObject){
        System.out.println("hhh");

        // GeometryDef
        if (jsonObject.containsKey("Samples")){
            SampleXmlBean sampleXmlBean = new SampleXmlBean();
            GeometryDef sGeo = new GeometryDef();
            JSONObject geometrydef = jsonObject.getJSONObject("Samples").getJSONObject("GeometryDef");
            if(geometrydef != null && geometrydef.containsKey("CoordSysStr")){
                sGeo.setCoordSysStr(geometrydef.getString("CoordSysStr"));
                sampleXmlBean.setGeometryDef(sGeo);
            }

            RegionsOfInterest sri = new RegionsOfInterest();
            JSONArray regions = jsonObject.getJSONObject("Samples").getJSONObject("RegionsOfInterest")
                    .getJSONArray("Region");
            if (  regions != null){
                List<Region> regionList = new ArrayList<>();
                for (int i=0; i< regions.size(); i++){
                    Region region = new Region();
                    JSONArray polygons = regions.getJSONObject(i).getJSONArray("Polygon");
                    if (polygons != null){
                        List<Polygon> polygonList = new ArrayList<>();
                        for (int k=0; k<polygons.size();k++){
                            //polygonList.add(new SampleXmlBean.Polygon(polygons.getJSONObject(k).getString("Polygon")));
                            //sdae与svm算法样本参数适用如下方式
                            polygonList.add(new Polygon(polygons.get(k).toString()));
                        }
                        region.setPolygons(polygonList);
                    }   
                    region.setName(regions.getJSONObject(i).getString("-name"));
                    region.setColor(regions.getJSONObject(i).getString("-color"));
                    regionList.add(region);
                }
                sri.setRegions(regionList);
            }
            sampleXmlBean.setRegionsOfInterest(sri);
            return sampleXmlBean;
        }
        return null;
    }


}
