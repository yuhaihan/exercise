package org.yhh.project.util;

import org.apache.pdfbox.io.RandomAccessBuffer;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.*;


/**
 * @ClassName: PDFExtractUtil
 * @Author: Gavin
 * @Create: 2021-07-02 10:15
 * @Version: 1.0
 * @Copyright: 2018~2021-07-02 10:15 www.clisia.cn. 保留所有权利。
 * 版权所有： 中科空间信息（廊坊）研究院。
 * 注意：本内容仅限于中科空间信息（廊坊）研究院内部传阅，禁止外泄以及用于其他的商业目的。
 */
public class PDFExtractUtil {

    public static void main(String[] args) throws IOException {
        String s = extractPDF("C:\\Users\\yhhus\\Desktop\\于海涵简历.pdf");
        String key = "姓名".toLowerCase();
        if (s.contains(key)) {
            System.out.println("成功");
        }
    }

    public static String extractPDF(String filePath) throws IOException {
        String result = null;
        FileInputStream is = null;
        PDDocument document = null;
        try {
            is = new FileInputStream(filePath);
            PDFParser parser = new PDFParser(new RandomAccessBuffer(is));
            parser.parse();
            document = parser.getPDDocument();
            PDFTextStripper stripper = new PDFTextStripper();
            result = stripper.getText(document);
        } finally {
            if (is != null) {
                is.close();
            }
            if (document != null) {
                document.close();
            }
        }
        String s = result.trim().toLowerCase();
        System.out.println(s);
        String ss = s.toLowerCase();
        System.out.println(ss);
        return s;
    }


}
