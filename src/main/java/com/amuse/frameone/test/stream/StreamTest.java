package com.amuse.frameone.test.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName StreamTest
 * @Description TODO
 * @Author 刘培振
 * @Date 2020-05-26 9:39
 * @Version 1.0
 */
public class StreamTest {

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("张三,");
//        list.add("李四,");
//        list.add("王五,");
//        list = list
//                .stream()
//                .peek((String s) -> s = s.replace(",","加油"))
//                .collect(Collectors.toList());
//
//
//        for (String s : list) {
//            System.out.println(s);
//        }
//        list = list.stream()
//                .map(s -> s.replace(",","加油"))
//                .collect(Collectors.toList());
//        for (String s : list) {
//            System.out.println(s);
//        }
//
//        list.stream().forEach(s -> s = s.replace("加油","加你妹"));
//        for (String s : list) {
//            System.out.println(s);
//        }
//
//        String[] strs = {"a","b","c","d","e","f","g"};
//        Arrays.stream(strs).peek(System.out::println).collect(Collectors.toList());

//        List<Student> list = new ArrayList<>();
//        for(int i = 0;i< 10; i++){
//            StreamTest streamTest = new StreamTest();
//            StreamTest.Student student = streamTest.new Student("张三",i+"");
//            list.add(student);
//        }
//        //list = list.stream().peek(s -> s.setAge("44")).collect(Collectors.toList());
//        list = list.stream().map(a ->{
//            a.setAge("44");
//            return a;
//        }).collect(Collectors.toList());
//
//        for (Student s : list){
//            System.out.println(s.age);
//        }

        Integer[] a = {1,2,4,5,6,7,8,3,2,1,3};
        List<Integer> list = Stream.of(a).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        for (Integer s : list){
            System.out.println(s);
        }


    }

    class Student {

        public Student(){

        }

        public Student(String name, String age) {
            this.name = name;
            this.age = age;
        }

        private String name;

        private String age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }

}
