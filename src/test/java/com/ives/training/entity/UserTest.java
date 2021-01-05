package com.ives.training.entity;

import com.ives.training.examination.Examination;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 * @DESCRIPTION:
 * @USER: ives
 * @DATE: 2020/9/21 14:25
 */
@SpringBootTest
public class UserTest {

    @Autowired
    Examination examination ;
    @Test
    public void UserTest(){
        Function<String,Integer> fun = Integer::parseInt;
        Integer value=fun.apply("123");
        System.out.println(value);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.forEach(System.out::println);
        list.forEach(i ->{
            if(i>1){
                System.out.println(i);
            }
        });
    }
    @Test
    public void getString(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","Bill");
        map.put("age",21);
        map.put("male",true);
        String s = "My name is {{ name }} and I am forever {{ age }}...";
        List<String> list1 = new ArrayList<>();//非{{}}字符
        List<String> list2 = new ArrayList<>();//{{}}内去除空格的字符
        int k = 0;
        int f = 0;
        int count = 0;
        //将{{}}中内容跟{{}}外内容分开存到两个list
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '{'){
                if(count==0){
                    list1.add(s.substring(k,i));
                    f=i+2;
                }
                count++;
            }
            if(s.charAt(i)=='}'){
                count--;
                if(count==0){
                    k=i;
                    String sub[] = s.substring(f,k-1).split(" ");
                    StringBuffer sb = new StringBuffer();
                    //这里直接用字符串拼接也可以
                    for (String su : sub){
                        sb.append(su);
                    }
                    list2.add(sb.toString());
                    k=k+1;
                }
            }
        }
        //根据判断key相对应的次数与list2的大小比对来判断是否全部填充，没有则抛出异常
        int num = 0;
        for(int i = 0;i<list2.size();i++){
            String s2 = list2.get(i);
            Iterator<String> iterator = map.keySet().iterator();
            boolean isError = false;
            while (iterator.hasNext()){
                String key = iterator.next();
                if(s2.equals(key)){
                    s2=map.get(key).toString();
                    num++;
                }
            }
            list2.remove(i);
            list2.add(i,s2);
        }
        if(num<list2.size()){
            throw new RuntimeException("出现错误");
        }


        //最后拼接好的字符串
        StringBuffer returnSB = new StringBuffer();
        for(int i = 0;i<list1.size();i++){
            returnSB.append(list1.get(i)+list2.get(i));
        }
        System.out.println(returnSB.toString());

    }

    @Test
    public void getStringTest(){
        examination.xGetString();
    }
}
