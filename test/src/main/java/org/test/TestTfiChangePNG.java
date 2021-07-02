package org.test;

import com.sun.jimi.core.Jimi;
import com.sun.jimi.core.JimiException;
import com.sun.jimi.core.JimiWriter;
import com.sun.jimi.core.options.PNGOptions;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageProducer;
import java.awt.image.Raster;
import java.io.*;
import java.util.Iterator;
import java.util.stream.IntStream;

/**
 * @ClassName: TestTfiChangePNG
 * @Description: TODO
 * @Author: Gavin
 * @Create: 2021-04-09 17:52
 * @Version: 1.0
 * @Copyright: 2018~2021-04-09 17:52 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
public class TestTfiChangePNG {

    public static void main(String[] args) {
        // convertTiffToPng(new File("C:\\Users\\yhhus\\Desktop\\十二五系统测试数据\\植被待检验产品.tif"));
        // changeTif2Jpg();
        String INPUT_PATH = "C:\\Users\\yhhus\\Desktop\\十二五系统测试数据\\植被待检验产品.tif";
        String OUTPUT_PATH = "C:\\Users\\yhhus\\Desktop\\十二五系统测试数据\\1-Beijing200204-Byte-7.png";
        imageConvertToPNG(INPUT_PATH,OUTPUT_PATH,"max");


    }

    public static void convertTiffToPng(File file) {
        try {
            try (InputStream is = new FileInputStream(file)) {
                try (ImageInputStream imageInputStream = ImageIO.createImageInputStream(is)) {
                    Iterator<ImageReader> iterator = ImageIO.getImageReaders(imageInputStream);
                    if (iterator == null || !iterator.hasNext()) {
                        throw new RuntimeException("Image file format not supported by ImageIO:" + file.getAbsolutePath());
                    }


                    // We are just looking for the first reader compatible:
                    ImageReader reader = iterator.next();
                    reader.setInput(imageInputStream);

                    int numPage = reader.getNumImages(true);

                    // it uses to put new png files, close to original example n0_.tiff will be in /png/n0_0.png
                    String name = "qwe12121212";
                    String parentFolder = file.getParentFile().getAbsolutePath();

                    IntStream.range(0, numPage).forEach(v -> {
                        try {
                            final BufferedImage tiff = reader.read(v);
                            ImageIO.write(tiff,"png", new FileOutputStream("C:\\Users\\yhhus\\Desktop\\十二五系统测试数据\\1-Beijing200204-Byte-5.png"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void changeTif2Jpg() {
        try {
            // String INPUT_PATH = tileOriginalPath + "\\" + tileName;
            // String OUTPUT_PATH = tileOriginalPath + "\\" + tileNameShort + ".p.jpg";

            String INPUT_PATH = "C:\\Users\\yhhus\\Desktop\\十二五系统测试数据\\植被待检验产品.tif";
            String OUTPUT_PATH = "C:\\Users\\yhhus\\Desktop\\十二五系统测试数据\\1-Beijing200204-Byte-3.png";
            File file = new File(INPUT_PATH);
            BufferedImage originalImage = ImageIO.read(file);
            int Row = originalImage.getHeight();
            int Col = originalImage.getWidth();
            BufferedImage finalImage = new BufferedImage(Row, Col, 8);
            Raster raster = originalImage.getData();
            int R = 0;
            int G = 0;
            int B = 0;
            double min = 0.0D;
            double max = 0.0D;
            for (int i = 0; i < 5000; i++) {
                for (int k = 0; k < 5000; k++) {
                    if (raster.getSampleDouble(i, k, 0) != -2.0D) {
                        if (min > raster.getSampleDouble(i, k, 0)) {
                            min = raster.getSampleDouble(i, k, 0);
                        }
                        if (max < raster.getSampleDouble(i, k, 0)) {
                            max = raster.getSampleDouble(i, k, 0);
                        }
                    }
                }
            }
            double del = (max - min) / 255.0D;
            for (int j = 0; j < 5000; j++) {
                for (int k = 0; k < 5000; k++) {
                    if (raster.getSampleDouble(j, k, 0) == -2.0D) {
                        R = G = B = 0;
                        Color finalColor = new Color(R, G, B);
                        finalImage.setRGB(j, k, finalColor.getRGB());
                    } else {
                        R = G = B = (int) ((raster.getSampleDouble(j, k, 0) - min) / del);
                        Color finalColor = new Color(R, G, B);
                        finalImage.setRGB(j, k, finalColor.getRGB());
                    }
                }
            }
            FileOutputStream fos = new FileOutputStream(OUTPUT_PATH);
            ImageIO.write(finalImage, "jpg", fos);
            // file.delete();
        } catch (Exception e) {
            System.out.println("在方法changTif2Jpg()中出错");
            e.printStackTrace();
        }
    }



    /**
     * 转换图像格式为 PNG
     *
     * @param sSourceImage , 其它格式的源图像文件路径
     * @param sDestImage   ,目标 PNG 图像文件存放路径
     * @param sCompression ,压缩比, none, default, fast, max
     * @return
     */
    public static boolean imageConvertToPNG(String sSourceImage, String sDestImage, String sCompression) {
        if (sSourceImage == null || sSourceImage.trim().equals("")) {
            System.out.println(" JimiImageUtil.convertToPNG() : 要转换的源图像文件路径不能为空！");
            return false;
        }
        if (sDestImage == null || sDestImage.trim().equals("")) {
            sDestImage = sSourceImage.substring(0, sSourceImage.lastIndexOf(".")) + ".png";
        } else if (!sDestImage.endsWith(".png")) {
            sDestImage += ".png";
        }
        //----------------------------------------------------------------------
        //检查源图像文件
        File tSourceImageFile = new File(sSourceImage);
        if (!tSourceImageFile.exists()) {
            System.out.println(" JimiImageUtil.convertToPNG() : 要转换的源图像文件路径不存在！");
            return false;
        } else if (!tSourceImageFile.canRead()) {
            System.out.println(" JimiImageUtil.convertToPNG() : 要转换的源图像文件路径不可读！");
            return false;
        } else if (!tSourceImageFile.isFile()) {
            System.out.println(" JimiImageUtil.convertToPNG() : 要转换的源图像路径不是一个有效的文件名！");
            return false;
        }
        tSourceImageFile = null;

        try {
            PNGOptions tPNGOptions = new PNGOptions();
            if (sCompression == null || sCompression.trim().equals("")) {
                tPNGOptions.setCompressionType(PNGOptions.COMPRESSION_DEFAULT);
            } else if (sCompression.equalsIgnoreCase("none")) {
                tPNGOptions.setCompressionType(PNGOptions.COMPRESSION_NONE);
            } else if (sCompression.equalsIgnoreCase("fast")) {
                tPNGOptions.setCompressionType(PNGOptions.COMPRESSION_FAST);
            } else if (sCompression.equalsIgnoreCase("max")) {
                tPNGOptions.setCompressionType(PNGOptions.COMPRESSION_MAX);
            } else {
                tPNGOptions.setCompressionType(PNGOptions.COMPRESSION_DEFAULT);
            }
            ImageProducer tImageProducer = Jimi.getImageProducer(sSourceImage);
            JimiWriter tJimiWriter = Jimi.createJimiWriter(sDestImage);
            tJimiWriter.setSource(tImageProducer);
            tJimiWriter.setOptions(tPNGOptions);
            tJimiWriter.putImage(sDestImage);
            tImageProducer = null;
            tJimiWriter = null;
            tPNGOptions = null;
        } catch (JimiException je) {
            System.out.println(" JimiImageUtil.convertToPNG() : 转换图像格式发生异常！");
            je.printStackTrace();
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }


}
