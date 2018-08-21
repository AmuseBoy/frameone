package com.amuse.frameone.test.oo;

/**
 * @ClassName Animal
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/5/18 9:51
 * @Version 1.0
 */
public class Animal {

    private String name;

    public Animal() {
        System.out.println("animal无参构造");
    }

    public Animal(String name) {
        System.out.println("animal有参构造:"+name);
        this.name = name;
    }
}
