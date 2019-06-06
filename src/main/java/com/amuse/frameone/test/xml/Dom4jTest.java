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

    /**
     * <?xml version="1.0" encoding="UTF-8"?>
     * <students>
     * 	<student id="01">
     *         <name>张三</name>
     *         <age>18</age>
     *     </student>
     *     <student id="02">
     *         <name>李四</name>
     *         <age>28</age>
     *     </student>
     *     <student id="01">
     *         <name>张三</name>
     *         <age>18</age>
     *     </student>
     *     <student id="02">
     *         <name>李四</name>
     *         <age>28</age>
     *     </student>
     * </students>
     * @param args
     */
    public static void main(String[] args) {
        try {
            SAXReader reader = new SAXReader();
            Document document = reader.read(new File("E:\\abc.xml"));
            Element rootElement = document.getRootElement();
            System.out.println(rootElement.getName());
            Element headElement = rootElement.element("student");
            System.out.println(headElement.getName());

//            System.out.println(rootElement.getName());
//            System.out.println(rootElement.getText());
            List<Element> elements = headElement.elements();
            for (Element element : elements) {
                System.out.println(element.getName());
                System.out.println(element.getTextTrim());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
