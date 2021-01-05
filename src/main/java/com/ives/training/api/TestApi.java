package com.ives.training.api;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.KeyManagementException;
import java.util.HashMap;
import java.util.Map;

/**
 * @DESCRIPTION:
 * @AUTHOR: ives
 * @DATE: 2020/12/30 16:47
 */
@RestController
public class TestApi {

    @PostMapping("/encrypt")
    public Map<String, String> encryption(@RequestParam("encryptVar") String encryptVar){
        Map<String, String> map = new HashMap();
            map.put("ciphertext", "123456");
        return map;
    }
}
