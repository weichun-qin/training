package com.ives.training.examination;


import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Map.Entry;

/**
 * @DESCRIPTION:
 * @USER: ives
 * @DATE: 2020/9/22 19:51
 */
@Service
public class Examination {

    public Map getPermitted(Entry required, Entry optional, Entry notNeeded){
        Map map = new LinkedHashMap();
        boolean isError = true;
        map.put(required.getKey().toString(),required.getValue().toString());
        map.put(optional.getKey().toString(),optional.getValue().toString());
        map.put(notNeeded.getKey().toString(),notNeeded.getValue().toString());
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            if(key.equals("required")){
                isError = false;
            }
            if(key.equals("notNeeded")){
                map.remove(key);
            }
        }
        if(isError){
            throw  new RuntimeException("没有必须要的参数");
        }
        return map;
    }

    public void getJson(String payload,String permittedKeys,String mandatoryKeys){

    }

    /**
     * 这是个错误的，性能消耗极高的
     */
    public void getString(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","Bill");
        map.put("age",21);
        map.put("male",true);
        String s = "My name is {{ name }} and I am forever {{ age }}...";
        List<String> list = new ArrayList<>();
        int k = 0;
        int f = 0;
        int count = 0;
        boolean valueIsFirst=false;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '{'){
                if(count==0){
                    f=i+2;
                    if(i==0){
                        valueIsFirst=true;
                    }else {
                        list.add(s.substring(k,i));
                    }
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
                    list.add(sb.toString());
                    k=k+1;
                }
            }
        }
        list.add(s.substring(s.lastIndexOf("}")+1,s.length()));
        //根据判断key相对应的次数与list2的大小比对来判断是否全部填充，没有则抛出异常
        int num = 0;
        int valueSize = 0;
        for(int i = 0;i<list.size();i++){
            String s2 = list.get(i);
            Iterator<String> iterator = map.keySet().iterator();
            if(valueIsFirst){
                if(i % 2 == 0){
                    while (iterator.hasNext()){
                        String key = iterator.next();
                        if(s2.equals(key)){
                            s2=map.get(key).toString();
                            num++;
                        }
                    }
                    valueSize++;
                    list.remove(i);
                    list.add(i,s2);
                }
            }else {
                if(i%2!=0){
                    while (iterator.hasNext()){
                        String key = iterator.next();
                        if(s2.equals(key)){
                            s2=map.get(key).toString();
                            num++;
                        }
                    }
                    valueSize++;
                    list.remove(i);
                    list.add(i,s2);
                }
            }

        }
        if(num<valueSize){
            throw new RuntimeException("出现错误");
        }


        //最后拼接好的字符串
        StringBuffer returnSB = new StringBuffer();
        for(int i = 0;i<list.size();i++){
            returnSB.append(list.get(i));
        }
        System.out.println(returnSB.toString());

    }

    public void xGetString(){
        String p = "我的名字是{{ name }}，我永远{{ age }}";
        Map<String, String> m = new HashMap();
        m.put("name", "123");
        m.put("age", "6666");

        StringBuffer sb = new StringBuffer(p);
        int first = 0;
        int last = 0;
        while (sb.indexOf("{{") != -1) {
            first = sb.indexOf("{{");
            last = sb.indexOf("}}");
            String key = (sb.substring(first + 2, last)).replace(" ","");
            String newValue = m.get(key);
            sb.replace(first, last + 2, newValue);
        }
        System.out.println(sb.toString());
    }

}
