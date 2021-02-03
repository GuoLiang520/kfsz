package com.gl.lucene;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.*;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;

/**
 *
 * @author 郭亮
 * @date 2021/1/25 14:01
 **/
public class Test {

    public static void main(String[] args) throws Exception {
        query();
    }

    private static void query() throws IOException, ParseException {
        FSDirectory directory = FSDirectory.open(Paths.get("E:\\lucene\\index"));
        DirectoryReader directoryReader = DirectoryReader.open(directory);
        IndexSearcher indexSearcher = new IndexSearcher(directoryReader);

       /* QueryParser queryParser = new QueryParser("filename", new StandardAnalyzer());
        Query test = queryParser.parse("test");*/
        /*MultiFieldQueryParser multiFieldQueryParser = new MultiFieldQueryParser(new String[]{"filename", "content"}, new StandardAnalyzer());
        Query test = multiFieldQueryParser.parse("zhangsan");*/
        //TermQuery test = new TermQuery(new Term("filename", "test"));
        MatchAllDocsQuery test = new MatchAllDocsQuery();
        TopDocs search =  indexSearcher.search(test, 10);
        ScoreDoc[] scoreDocs = search.scoreDocs;
        for (ScoreDoc scoreDoc: scoreDocs) {
            //从索引中查询到文档的ID，
            int doc = scoreDoc.doc;
            //在根据ID到文档中查找文档内容
            Document document = indexSearcher.doc(doc);
            System.out.println(document.get("filename") + ":" + document.get("content"));
        }
        directoryReader.close();
    }

    private static void deleteDocument() throws IOException {
        FSDirectory directory = FSDirectory.open(Paths.get("E:\\lucene\\index"));
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(new StandardAnalyzer());
        IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
        indexWriter.deleteDocuments(new Term("filename", "test"));
        indexWriter.commit();
        indexWriter.close();
    }

    private static void addDocument() throws IOException {
        FSDirectory directory = FSDirectory.open(Paths.get("E:\\lucene\\index"));
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(new StandardAnalyzer());
        IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
        Document document = new Document();
        TextField textField = new TextField("filename", "zhaoqi", Field.Store.YES);
        TextField content = new TextField("content", "my name is wangwu", Field.Store.YES);
        document.add(textField);
        document.add(content);
        indexWriter.addDocument(document);
        indexWriter.commit();
        indexWriter.close();
    }
}
