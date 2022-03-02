package com.xiaoduomi.jfreechart;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Vector;

import com.xiaoduomi.http.Serie;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.PieLabelLinkStyle;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;
import java.util.logging.Logger;

/**
 * @ClassName: CreateLineChart
 * @Description: chuangjianzhexiantu
 * @Author: Gavin
 * @Create: 2022-01-10 15:37
 * @Version: 1.0
 * @Copyright: 2018~2022-01-10 15:37 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
public class CreateLineChart {

    private static final Logger logger = Logger.getLogger(CreateLineChart.class.getName());

    private static String NO_DATA_MSG = "数据加载失败";
    private static Font FONT = new Font("宋体", Font.PLAIN, 12);

    /**
     * 颜色
     */
    public static Color[] CHART_COLORS = {
            new Color(31, 129, 188),
            new Color(92, 92, 97),
            new Color(144, 237, 125),
            new Color(255, 188, 117),
            new Color(153, 158, 255),
            new Color(255, 117, 153),
            new Color(253, 236, 109),
            new Color(128, 133, 232),
            new Color(158, 90, 102),
            new Color(255, 204, 102)
    };

    static {
        setChartTheme();
    }

    public CreateLineChart() {

    }


    //public static void main(String[] args) {
    //    String tile = "光谱曲线图";
    //    String xTile = "波长（单位/nm）";
    //    String yTile = "地表反射率值";
    //    String filepath = "C:\\Users\\yhhus\\Desktop\\dbfsl\\光谱曲线图-1.png";
    //    String[] categories = {"0", "200", "400", "600", "800", "1000", "1200", "1400", "1600", "1800", "2000", "2250"};
    //    Vector<Serie> series = new Vector<>();
    //    series.add(new Serie("波长        \n\r地表反射率", new Double[]{0.1, 0.5, 0.4, 0.2, 0.0, 0.3, 0.6, 0.5, 0.4, 0.1, 0.6, 0.4}));
    //
    //    CreateNewLineChartForPng(tile, xTile, yTile, filepath, Arrays.asList(categories), series, 550, 350);
    //}


    /**
     * 生成一个这先出并保存为png格式 TODO  可以通过调用这个方法, 提供对应格式的参数即可生成图片,并存在指定位置
     *
     * @param title    图片标题
     * @param xTitle   x轴标题
     * @param yTitle   y轴标题
     * @param filePath 文件路径+文件名
     * @param category 横坐标类型
     * @param series   数据内容
     * @param width    图片宽度
     * @param height   图片高度
     * @throws Exception
     */
    public static void CreateNewLineChartForPng(String title, String xTitle, String yTitle, String
            filePath, java.util.List<String> category, java.util.List<Serie> series, int width, int height) {
        try {
            ChartPanel chartPanel = new CreateLineChart().createChart(title, xTitle, yTitle, category, series);
            //将图片保存为png格式
            saveAsFile(chartPanel.getChart(), filePath, width, height);
        } catch (Exception e) {
            logger.warning("创建折线图异常：" + e);
        }

    }

    /**
     * 将图表保存为PNG、JPEG图片
     *
     * @param chart      折线图对象
     * @param outputPath 文件保存路径, 包含文件名
     * @param weight     宽
     * @param height     高
     * @throws Exception
     */
    public static void saveAsFile(JFreeChart chart, String outputPath, int weight, int height) throws Exception {
        FileOutputStream out = null;
        File outFile = new File(outputPath);
        if (!outFile.getParentFile().exists()) {
            outFile.getParentFile().mkdirs();
        }
        out = new FileOutputStream(outputPath);
        // 保存为PNG
        ChartUtilities.writeChartAsPNG(out, chart, weight, height);
        out.flush();
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 创建折线图
     *
     * @param title    折线图标题
     * @param xTitle   x轴标题
     * @param yTitle   y轴标题
     * @param category 横坐标类别
     * @param series   数据集
     * @return
     * @throws Exception
     */
    public ChartPanel createChart(String title, String xTitle, String yTitle, List<String> category, List<Serie> series) {
        // 2：创建Chart[创建不同图形]
        JFreeChart chart = ChartFactory.createLineChart(title, xTitle, yTitle, createDataset(category, series));
        // 3:设置抗锯齿，防止字体显示不清楚
        // 抗锯齿
        chart.setTextAntiAlias(false);
        // 4:对柱子进行渲染[[采用不同渲染]]
        CreateLineChart.setLineRender(chart.getCategoryPlot(), false, true);
        // 5:对其他部分进行渲染
        // X坐标轴渲染
        CreateLineChart.setXAixs(chart.getCategoryPlot());
        // Y坐标轴渲染
        CreateLineChart.setYAixs(chart.getCategoryPlot());
        // 设置标注无边框
        chart.getLegend().setFrame(new BlockBorder(Color.WHITE));
        // 6:使用chartPanel接收
        ChartPanel chartPanel = new ChartPanel(chart);
        return chartPanel;
    }

    /**
     * 创建折线图图表
     *
     * @param categorie
     * @param series
     * @return
     */
    public DefaultCategoryDataset createDataset(List<String> categorie, List<Serie> series) {
        // 标注类别
        String[] categories = categorie.toArray(new String[categorie.size()]);
        DefaultCategoryDataset dataset = CreateLineChart.createDefaultCategoryDataset(series, categories);
        return dataset;
    }

    /**
     * 创建类别数据集合
     *
     * @param series
     * @param categories
     * @return
     */
    public static DefaultCategoryDataset createDefaultCategoryDataset(List<Serie> series, String[] categories) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Serie serie : series) {
            String name = serie.getName();
            Vector<Object> data = serie.getData();
            if (data != null && categories != null && data.size() == categories.length) {
                for (int index = 0; index < data.size(); index++) {
                    String value = data.get(index) == null ? "" : data.get(index).toString();
                    if (isPercent(value)) {
                        value = value.substring(0, value.length() - 1);
                    }
                    if (isNumber(value)) {
                        dataset.setValue(Double.parseDouble(value), name, categories[index]);
                    }
                }
            }

        }
        return dataset;

    }

    /**
     * 是不是一个%形式的百分比
     *
     * @param str
     * @return
     */
    public static boolean isPercent(String str) {
        return str != null && str.endsWith("%") && isNumber(str.substring(0, str.length() - 1));
    }

    /**
     * 是不是一个数字
     *
     * @param str
     * @return
     */
    public static boolean isNumber(String str) {
        return str != null && str.matches("^[-+]?(([0-9]+)((([.]{0})([0-9]*))|(([.]{1})([0-9]+))))$");
    }

    /**
     * 设置折线图样式
     *
     * @param plot
     * @param isShowDataLabels 是否显示数据标签
     */
    @SuppressWarnings("deprecation")
    public static void setLineRender(CategoryPlot plot, boolean isShowDataLabels, boolean isShapesVisible) {
        plot.setNoDataMessage(NO_DATA_MSG);
        plot.setInsets(new RectangleInsets(10, 10, 0, 10), false);
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();

        renderer.setStroke(new BasicStroke(1.5F));
        if (isShowDataLabels) {
            renderer.setBaseItemLabelsVisible(true);
            renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator(StandardCategoryItemLabelGenerator.DEFAULT_LABEL_FORMAT_STRING,
                    NumberFormat.getInstance()));
            renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE1, TextAnchor.BOTTOM_CENTER));// weizhi
        }
        renderer.setBaseShapesVisible(isShapesVisible);// 数据点绘制形状
        setXAixs(plot);
        setYAixs(plot);

    }


    /**
     * 设置类别图表(CategoryPlot) X坐标轴线条颜色和样式
     *
     * @param plot
     */
    public static void setXAixs(CategoryPlot plot) {
        Color lineColor = new Color(31, 121, 170);
        // X坐标轴颜色
        plot.getDomainAxis().setAxisLinePaint(lineColor);
        // X坐标轴标记|竖线颜色
        plot.getDomainAxis().setTickMarkPaint(lineColor);

    }

    /**
     * 设置类别图表(CategoryPlot) Y坐标轴线条颜色和样式 同时防止数据无法显示
     *
     * @param plot
     */
    public static void setYAixs(CategoryPlot plot) {
        Color lineColor = new Color(192, 208, 224);
        ValueAxis axis = plot.getRangeAxis();
        // Y坐标轴颜色
        axis.setAxisLinePaint(lineColor);
        // Y坐标轴标记|竖线颜色
        axis.setTickMarkPaint(lineColor);
        // 隐藏Y刻度
        axis.setAxisLineVisible(false);
        axis.setTickMarksVisible(false);
        // Y轴网格线条
        plot.setRangeGridlinePaint(new Color(192, 192, 192));
        plot.setRangeGridlineStroke(new BasicStroke(1));
        // 设置顶部Y坐标轴间距,防止数据无法显示
        plot.getRangeAxis().setUpperMargin(0.1);
        // 设置底部Y坐标轴间距
        plot.getRangeAxis().setLowerMargin(0.1);

    }


    /**
     * 中文主题样式 解决乱码
     */
    private static void setChartTheme() {
        // 设置中文主题样式 解决乱码
        StandardChartTheme chartTheme = new StandardChartTheme("CN");
        // 设置标题字体
        chartTheme.setExtraLargeFont(FONT);
        // 设置图例的字体
        chartTheme.setRegularFont(FONT);
        // 设置轴向的字体
        chartTheme.setLargeFont(FONT);
        chartTheme.setSmallFont(FONT);
        chartTheme.setTitlePaint(new Color(51, 51, 51));
        chartTheme.setSubtitlePaint(new Color(85, 85, 85));
        // 设置标注
        chartTheme.setLegendBackgroundPaint(Color.WHITE);
        chartTheme.setLegendItemPaint(Color.BLACK);
        chartTheme.setChartBackgroundPaint(Color.WHITE);

        Paint[] OUTLINE_PAINT_SEQUENCE = new Paint[]{Color.WHITE};
        // 绘制器颜色源
        DefaultDrawingSupplier drawingSupplier = new DefaultDrawingSupplier(CHART_COLORS, CHART_COLORS, OUTLINE_PAINT_SEQUENCE,
                DefaultDrawingSupplier.DEFAULT_STROKE_SEQUENCE, DefaultDrawingSupplier.DEFAULT_OUTLINE_STROKE_SEQUENCE,
                DefaultDrawingSupplier.DEFAULT_SHAPE_SEQUENCE);
        chartTheme.setDrawingSupplier(drawingSupplier);
        // 绘制区域
        chartTheme.setPlotBackgroundPaint(Color.WHITE);
        // 绘制区域外边框
        chartTheme.setPlotOutlinePaint(Color.WHITE);
        // 链接标签颜色
        chartTheme.setLabelLinkPaint(new Color(8, 55, 114));
        chartTheme.setLabelLinkStyle(PieLabelLinkStyle.CUBIC_CURVE);

        chartTheme.setAxisOffset(new RectangleInsets(5, 12, 5, 12));
        // X坐标轴垂直网格颜色
        chartTheme.setDomainGridlinePaint(new Color(192, 208, 224));
        // Y坐标轴水平网格颜色
        chartTheme.setRangeGridlinePaint(new Color(192, 192, 192));

        chartTheme.setBaselinePaint(Color.WHITE);
        // 不确定含义
        chartTheme.setCrosshairPaint(Color.BLUE);
        // 坐标轴标题文字颜色
        chartTheme.setAxisLabelPaint(new Color(51, 51, 51));
        // 刻度数字
        chartTheme.setTickLabelPaint(new Color(67, 67, 72));
        // 设置柱状图渲染
        chartTheme.setBarPainter(new StandardBarPainter());
        // XYBar 渲染
        chartTheme.setXYBarPainter(new StandardXYBarPainter());
        chartTheme.setItemLabelPaint(Color.black);
        // 温度计
        chartTheme.setThermometerPaint(Color.white);
        ChartFactory.setChartTheme(chartTheme);
    }
}
