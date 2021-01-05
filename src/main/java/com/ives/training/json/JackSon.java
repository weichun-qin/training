package com.ives.training.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ives.training.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @DESCRIPTION:
 * @USER: ives
 * @DATE: 2020/10/29 16:58
 */
@Component
public class JackSon {

    public void  jackSonTest() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = new User();
        user.setName("许宸玮");
        user.setAge(23);
        user.setAttributes("sb");
        String json = objectMapper.writeValueAsString(user);
        System.out.println(json);
        User user1 = objectMapper.readValue(json,User.class);
        System.out.println(user1.toString());
        Map<String,Object> userMap = new HashMap<>();
        userMap.putAll(objectMapper.convertValue(userMap,Map.class));
        Iterator<String> iterator = userMap.keySet().iterator();
        while (iterator.hasNext()){
            System.out.println(userMap.get(iterator.next()));
        }
    }

}
