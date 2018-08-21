package com.amuse.frameone.test.jvm;

import java.util.ArrayList;

/**
 * @ClassName Heap
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/7/28 10:57
 * @Version 1.0
 */
public class Heap {

    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        while (true){
            list.add(new Heap());
        }
    }
}
