package com.amuse.frameone.common.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * @ClassName Student
 * @Description Mongo的实体类
 * @Author 刘培振
 * @Date 2018/10/12 17:38
 * @Version 1.0
 */
@Document(collection = "student")
public class Student implements Serializable {

    @Id  //加上@ID注解 或者 属性名为id会自动映射 mongo里的 _id属性，
         // 只有属性为String类型，才会使用MongoDB的ObjectId,否则id值需要赋值
    private String id;

    @Field("name")
    private String name;

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
