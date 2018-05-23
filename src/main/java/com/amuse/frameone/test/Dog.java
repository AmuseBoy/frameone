package com.amuse.frameone.test;

/**
 * @ClassName Dog
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/5/18 9:53
 * @Version 1.0
 */
public class Dog extends Animal {


    public Dog(){
        System.out.println("Dog无参构造");
    }

    public Dog(String name) {
        //super(name);
        System.out.println("Dog有参构造");
    }


    public static void main(String[] args) {
        Dog dog = new Dog();
        Dog dog1 = new Dog("大黄");
    }
}
