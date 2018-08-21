package com.amuse.frameone.test.jvm;

/**
 * @ClassName Stack
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/7/28 11:51
 * @Version 1.0
 */
public class Stack {

    public static void main(String[] args) {
        new Stack().test();
    }

    public void test(){
        test();
    }
}
