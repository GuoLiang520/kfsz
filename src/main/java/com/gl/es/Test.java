package com.gl.es;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 *
 * @author 郭亮
 * @date 2021/2/3 16:38
 **/
public class Test {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("192.168.0.111", 9200, "http")));
        //creatIndex(client);
        //deleteIndex(client);
        //existIndex(client);
        //addDoc(client);
        //deleteDoc(client);
        UpdateRequest updateRequest = new UpdateRequest("test", "1");
        updateRequest.id("1");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name2","中华人民共和国合同法");
        jsonObject.put("price", 500);
        jsonObject.put("aa", "!3");
        updateRequest.doc(jsonObject.toJSONString(), XContentType.JSON);
        client.update(updateRequest, RequestOptions.DEFAULT);
        client.close();
    }

    private static void deleteDoc(RestHighLevelClient client) throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest("test");
        deleteRequest.id("1");
        client.delete(deleteRequest, RequestOptions.DEFAULT);
    }

    private static void addDoc(RestHighLevelClient client) throws IOException {
        IndexRequest test = new IndexRequest("test");
        test.id("1");
        test.source("{\n" +
                "  'name2':'中华人民共和国合同法',\n" +
                "  'price':500\n" +
                "}", XContentType.JSON);
        IndexResponse index = client.index(test, RequestOptions.DEFAULT);
        System.out.println(index.status());
    }

    private static void existIndex(RestHighLevelClient client) throws IOException {
        GetIndexRequest getIndexRequest = new GetIndexRequest("test");
        boolean exists = client.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    private static void deleteIndex(RestHighLevelClient client) throws IOException {
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("test");
        client.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
    }

    private static void creatIndex(RestHighLevelClient client) throws IOException {
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("test");
        createIndexRequest.settings(Settings.builder().put("number_of_shards","2").put("number_of_replicas", "2"));
        client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
    }
}
