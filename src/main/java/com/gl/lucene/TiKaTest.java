package com.gl.lucene;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;

import java.io.File;
import java.io.FileInputStream;

/**
 *
 * @author 郭亮
 * @date 2021/1/25 11:45
 **/
public class TiKaTest {

    public static void main(String[] args) throws Exception {
        File file = new File("E:\\Zha\\t.pdf");
        Metadata metadata = new Metadata();
        metadata.set(Metadata.CONTENT_ENCODING, "utf-8");
        metadata.set(Metadata.RESOURCE_NAME_KEY, file.getName());
        BodyContentHandler bodyContentHandler = new BodyContentHandler();

        ParseContext parseContext = new ParseContext();
        AutoDetectParser autoDetectParser = new AutoDetectParser();
        parseContext.set(Parser.class, autoDetectParser);
        autoDetectParser.parse(new FileInputStream(file), bodyContentHandler,metadata, parseContext);
        System.out.println(bodyContentHandler.toString());
    }
}
