package com.amuse.frameone.test.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * @ClassName Dom4jTest
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/8/29 11:53
 * @Version 1.0
 */
public class Dom4jTest {

    public static void main(String[] args) {
        try {
            SAXReader reader = new SAXReader();
            Document document = reader.read(new File("E:\\a\\b\\c\\qwe.xml"));
            Element rootElement = document.getRootElement();
            Element headElement = rootElement.element("HEAD");
            //if(headElement.)


//            System.out.println(rootElement.getName());
//            System.out.println(rootElement.getText());
//            List<Element> elements = rootElement.elements();
//            for (Element element : elements) {
//                System.out.println(element.getName());
//                System.out.println(element.getTextTrim());
//            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
