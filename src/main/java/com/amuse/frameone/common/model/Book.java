package com.amuse.frameone.common.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @ClassName Book
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/5/22 17:27
 * @Version 1.0
 */
@XmlRootElement     //让该类可以解析为xml格式
public class Book {

    private String id;
    private String name;

    public Book(){

    }

    public Book(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
