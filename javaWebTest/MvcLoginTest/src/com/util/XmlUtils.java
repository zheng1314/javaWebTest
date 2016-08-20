package com.util;

/**
 * Created by zheng1617 on 16-7-20.
 */
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class XmlUtils {

    private static String filename = "DB.xml";

    public static Document getDocument() throws DocumentException {
        URL url = XmlUtils.class.getClassLoader().getResource(filename);
        String realPath = url.getPath();

        SAXReader reader = new SAXReader();
        return reader.read(new File(realPath));
    }
    public static void write2Xml(Document document) throws IOException {
        URL url = XmlUtils.class.getClassLoader().getResource(filename);
        String realPath = url.getPath();

        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter Writer = new XMLWriter(new FileOutputStream(realPath), format);

        Writer.write(document);
        Writer.close();
        System.out.println(realPath);
    }
}
