package com.gl.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.util.IOUtils;

import java.io.Reader;
import java.io.StringReader;

/**
 *
 * @author 郭亮
 * @date 2021/1/26 14:34
 **/
public class IKAnalyzer extends Analyzer {
    @Override
    protected TokenStreamComponents createComponents(String s) {
        Reader reader=null;
        try{
            reader = new StringReader(s);
            IKTokenizer it = new IKTokenizer();
            return new Analyzer.TokenStreamComponents(it);
        }finally {
            IOUtils.closeWhileHandlingException(reader);
        }
    }
}
