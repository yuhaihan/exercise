package org.yhh.project.util;


import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.model.TextPieceTable;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;

import java.io.*;
import java.util.List;

/**
 * @author yhhus
 */
public class WordExtractUtil {

    public static void main(String[] args) throws IOException {
        String s = extractWord("C:\\Users\\yhhus\\Desktop\\于海涵简历.docx");
        String key = "Java".toLowerCase();
        if (s.contains(key)) {
            System.out.println("成功");
        }

    }

    public static String extractWord(String filePath) throws IOException {
        String result = null;
        File file = new File(filePath);
        InputStream inputStream = new BufferedInputStream(new FileInputStream(filePath));
        System.out.println(FileMagic.valueOf(inputStream));
        String text = "";
        if (FileMagic.valueOf(inputStream) == FileMagic.OLE2) {
            WordExtractor ex = new WordExtractor(inputStream);
            text = ex.getText();
            ex.close();
        } else if (FileMagic.valueOf(inputStream) == FileMagic.OOXML) {
            XWPFDocument doc = new XWPFDocument(inputStream);
            XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
            text = extractor.getText();
            XWPFDocument document = extractor.getDocument();
            List<XWPFTable> tables = document.getTables();
            tables.forEach(t->{
                String text1 = t.getText();
                System.out.println(text1);
            });

            extractor.close();
        }
        System.out.println(text.toLowerCase());
        return text.toLowerCase();
    }

}
