package com.gl.controller;

import com.gl.entity.Employee;
import com.alibaba.fastjson.JSONObject;
import com.gl.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.validation.Valid;

/**
 *
 * @author 郭亮
 * @date 2020/9/23 9:59
 **/
@Controller
public class TestController {

    @Autowired
    private TestService testService;

    private static int i = 1;

    @RequestMapping(value = "/test.do")
    @ResponseBody
    public Object test(String ahdm){
        return testService.getEaj(ahdm);
    }

    @RequestMapping(value = "/save.do")
    @ResponseBody
    public Object save(){
        testService.insertEaj();
        return "success";
    }

    @RequestMapping(value = "/getByNd.do")
    @ResponseBody
    public Object getByNd(){
        testService.getByNd();
        return "success";
    }

    @RequestMapping(value = "/saveJpa.do")
    @ResponseBody
    public Object saveJpa(){
        testService.saveJpa();
        return "success";
    }

    @RequestMapping(value = "/getJpa.do")
    @ResponseBody
    public Object getJpa(String ahdm){
        return testService.getJpa(ahdm);
    }


    @RequestMapping(value = "/getEmployee.do")
    @ResponseBody
    public Object getEmployee(@Valid Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            result.getAllErrors().forEach(a->{
                System.out.println(a.getDefaultMessage());
            });
        }
        return employee;
    }

    @RequestMapping(value = "/api/v1/archivesFileNotice",method = RequestMethod.POST)
    @ResponseBody
    public Object archivesFileNotice(@RequestBody String json) {
        System.out.println(json);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("message", "响应消息");
        jsonObject.put("data", "data3");
        return jsonObject;
    }

    @RequestMapping(value = "/api/v1/token")
    @ResponseBody
    public Object getToken(@RequestBody String json){
        System.out.println("/api/v1/token");
        System.out.println(json);
        return "{ \"access_token\": \"7fc56793-beea-4cbb-8546-22815dce5ad1\", \"token_type\": \"bearer\",\n" +
                "\"expires_in\": 30935, \"scope\": \"all\" }\n";
    }

    @RequestMapping(value = "/api/v1/tmp")
    @ResponseBody
    private Object uploadfile(@RequestParam(value = "file") MultipartFile file) throws IOException {
        System.out.println("/api/v1/tmp");
        file.transferTo(new File("E:\\Zha\\tmp.doc"));
        return "{\n" +
                " \"id\": \"402883506d37c3c6016d381281330000\",\n" +
                " \"name\": \"签章文件\",\n" +
                "\"full_name \": \"签章文件.doc\",\n" +
                " \"description\": null,\n" +
                " \"storeFullPath\": \"group1/M00/0B/FB/wKgDo11-_qGAFr_bAAD9fADfLMQ8255835\",\n" +
                " \"storeGroup\": \"group1\",\n" +
                " \"storePath\": \"M00/0B/FB/wKgDo11-_qGAFr_bAAD9fADfLMQ8255835\",\n" +
                " \"contentType\":\n" +
                "\"application/vnd.openxmlformats-officedocument.wordprocessingml.document\",\n" +
                " \"size\": 64892,\n" +
                " \"crc\": 14625988,\n" +
                " \"tmp\": true,\n" +
                " \"createTime\": 1568603809,\n" +
                " \"expire\": 1296000000,\n" +
                " \"updateTime\": 0,\n" +
                " \"deleted\": false,\n" +
                " \"deletedTime\": 0,\n" +
                " \"expired\": true,\n" +
                " \"enabled\": true,\n" +
                " \"resourceName\": \"FastDFSFile\"\n" +
                "}";
    }

    @RequestMapping(value = "/api/v1/getUserId")
    @ResponseBody
    public Object getUserId(String userCode){
        System.out.println("/api/v1/getUserId");
        System.out.println(userCode);
        return i++;
    }

    @RequestMapping(value = "/api/v1/collegialSign")
    @ResponseBody
    public Object getTaskid(@RequestBody String json) {
        System.out.println("/api/v1/collegialSign");
        System.out.println(json);
        return "{\n" +
                "\"id\": \"QWERTYUIOP-ASDFGHJKL-XCVNM\",\n" +
                "\"file\":\"string\",\n" +
                "\"caseSign\": \"string\",\n" +
                "\"app\": \"string\",\n" +
                "\"docType\": \"string\",\n" +
                " \"expiryTime\": 1567415018238,\n" +
                " \"createdTime\": 1567415018238,\n" +
                "\"pdf\": false,\n" +
                "\" background \": true\n" +
                " }";
    }

    @RequestMapping(value = "/api/v1/task/{id}")
    public void getFile(@PathVariable(value = "id") String id, HttpServletResponse response) throws IOException {
        System.out.println("/api/v1/task/{id}");
        System.out.println(id);
        response.setHeader("Content-disposition", "attachment;filename=t.pdf" );// 设置头部信息
        ServletOutputStream outputStream = response.getOutputStream();
        FileCopyUtils.copy(Files.readAllBytes(Paths.get("E:\\Zha\\t.pdf")), outputStream);
    }

    @RequestMapping(value = "/api/v1/getCourtUserSealsByParams")
    @ResponseBody
    public Object getCourtUserSealsByParams(String courtNo, String userId, String sealType) {
        System.out.println("/api/v1/getCourtUserSealsByParams");
        System.out.println(courtNo);
        System.out.println(userId);
        System.out.println(sealType);
        return "[\n" +
                "\t{\n" +
                "\t\t\"name\": \"xxx 章\",\n" +
                "\t\t\"id\": \"12312\",\n" +
                "\t\t\"type\": 0,\n" +
                "\t\t\"countNo\": \"1850\"\n" +
                "\t}\n" +
                "]";
    }
}
