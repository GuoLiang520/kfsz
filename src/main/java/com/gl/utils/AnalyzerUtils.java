package com.gl.utils;

import com.gl.lucene.IKAnalyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;

import java.io.IOException;

/**
 *
 * @author 郭亮
 * @date 2021/1/22 16:54
 **/
public class AnalyzerUtils {

    public static void main(String[] args) throws IOException {
        IKAnalyzer standardAnalyzer = new IKAnalyzer();
        TokenStream cont = standardAnalyzer.tokenStream("cont", "中华人民共和国国歌");
        cont.reset();
        CharTermAttribute attribute = cont.getAttribute(CharTermAttribute.class);
        OffsetAttribute offsetAtt  = cont.getAttribute(OffsetAttribute.class);
        TypeAttribute typeAtt = cont.getAttribute(TypeAttribute.class);
        while (cont.incrementToken()){
            System.out.print(attribute + "|");
            System.out.print(offsetAtt.startOffset() + "|" + offsetAtt.endOffset() + "|");
            System.out.print(typeAtt.type() + "|");
            System.out.println();
        }
    }
}
