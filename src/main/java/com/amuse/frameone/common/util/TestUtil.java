package com.amuse.frameone.common.util;

import com.amuse.frameone.common.model.Book;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @ClassName TestUtil
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/5/2 15:46
 * @Version 1.0
 */
public class TestUtil {

    public static void main(String[] args) {
        //System.out.println(UUID.randomUUID().toString());
//        PasswordEncoder encoder = new BCryptPasswordEncoder();
//        System.out.println(encoder.encode("123456"));

//        List<Map<String,Object>> list = new ArrayList<>();
//        System.out.println(list.size());


//        Date date = new Date();
//        System.out.println(date != null);

//        List<String> list = new ArrayList<>();
//        list.add("ss");
//        list.add("xx");
//        System.out.println(list.toString());

//        Object[] objects = new Object[]{"ss","xx"};
//        String[] arrays = new String[]{"xx","ww"};
//        //System.out.println(Arrays.toString(objects));
//        System.out.println(Arrays.asList(arrays));

//        Random random = new Random();
//        int ra = random.nextInt(25)+1;
//        System.out.println(ra);

//        Book book = new Book();
//        set(book);
//        System.out.println(book.getName());

//        String[] s = "".split(",");
//        System.out.println(s.toString());

//        String[] s = {"ss","ss","xx"};
//        List<String> list = new ArrayList<>();
//        list = Arrays.asList(s);
//        list.subList(0,9);

//        List<String> list = new ArrayList<>();
//        list.add("s");
//        list.add("b");
//        List<String> list1 = new ArrayList<>();
//        list1.add("s");
//        list1.add("s");
//        list1.add("s");
//        list1.add("b");
//        list1.add("r");
//        list1.add("t");
//        System.out.println(list1.size());
////        for (String s : list){
////            list1.remove(s);
////        }
//        list1.removeAll(list);
//        System.out.println(list1.size());




//        //生成唯一数字
//        UUID uuid = UUID.randomUUID();
//        System.out.println(uuid);
//        System.out.println(Math.abs(uuid.getMostSignificantBits()));
//        Integer i = 1;
//        if(i.equals(1)){
//            System.out.println("sss");
//        }
//        long l = 1536215100000l;
//        long ls = 1535699922822l;
//        System.out.println(new Date(l)+" "+new Date(ls));
//        System.out.println(new Date().getTime());

//        Book book = new Book("22","sss");
//        Book book1 = new Book("11","sss");
//        boolean b = StringUtils.equals(book.getName(),book1.getName());
//        System.out.println(b);

        System.out.println("结果"+TestUtil.test2(6));
    }

    private static String test2(int n){
        String result = "";
        for(int i=1 ;i <= n ; i++){
            if(i == 1){
                result = "1";
            } else {
                StringBuilder sb = new StringBuilder();
                int count = 0;
                char temp = result.charAt(0);
                for(int j=0;j<result.length();j++){
                    if(result.charAt(j) == temp){
                        count++;
                    }else {
                        sb.append(count).append(temp);
                        temp = result.charAt(j);
                        count = 1;
                    }
                }
                sb.append(count).append(temp);
                System.out.println(sb);
                result = sb.toString();
            }
        }
        return result;
    }

    public static void set(Book book){
        book.setName("sss");
    }
}
