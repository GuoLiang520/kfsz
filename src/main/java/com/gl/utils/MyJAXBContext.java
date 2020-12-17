package com.gl.utils;

import com.gl.entity.Eaj;
import com.gl.entity.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;

/**
 *
 * @author 郭亮
 * @date 2020/12/17 9:35
 **/
public class MyJAXBContext {

    /**
     *
     * @param args args
     * @throws JAXBException JAXBException
     */
    public static void main(String[] args) throws JAXBException {
        marshaller();
    }

    private static void unmarshaller() throws JAXBException {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><eaj><ahdm>123</ahdm><ah>案号</ah><test><name>test1</name></test><test><name>测试1</name></test></eaj>";
        JAXBContext jaxbContext = JAXBContext.newInstance(Eaj.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Object unmarshal = unmarshaller.unmarshal(new StringReader(xml));
        System.out.println(unmarshal);
    }

    /**
     *
     * @throws JAXBException JAXBException
     */
    private static void marshaller() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Eaj.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        Eaj eaj = new Eaj();
        eaj.setAhdm("123");
        eaj.setAh("案号");
        ArrayList<Test> tests = new ArrayList<>();
        tests.add(new Test("test1"));
        tests.add(new Test("测试1"));
        eaj.setTests(tests);
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(eaj, stringWriter);
        System.out.println(stringWriter.toString());
    }
}
