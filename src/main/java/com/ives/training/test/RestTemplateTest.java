package com.ives.training.test;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.persistence.Cacheable;
import java.util.HashMap;
import java.util.Map;

/**
 * @DESCRIPTION:
 * @AUTHOR: ives
 * @DATE: 2020/12/31 13:32
 */
@Component
public class RestTemplateTest {
    private static final Logger logger = LoggerFactory.getLogger(RestTemplateTest.class);
    @Autowired
    private RestTemplate restTemplate;

    private static String address = "http://127.0.0.1:9090";


    public byte[] encryption(byte[] var) throws Exception {
        if (var == null || var.length <= 0) {
            throw new Exception("var is empty");
        } else {
            Map<String, String> send = new HashMap();
            send.put("encryptVar", Base64.encodeBase64String(var));
            Map<String, Object> map = new HashMap<>();
            ResponseEntity<Map<String, String>> responseEntity;
            try {
                logger.info("HSM URL:" + address + "/encrypt");
                responseEntity = (ResponseEntity<Map<String, String>>) this.sendPost(address + "/encrypt", send, Map.class);
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("HSM URL:" + address + "/encrypt");
                logger.info("HSM：Encryption Timeout");
                logger.info("HSM：Use alternate URL");
                map = restTemplate.postForObject(address + "/encrypt", send, Map.class);
            }
            if (map != null && map.size() > 0) {
                return Base64.decodeBase64(map.get("ciphertext").toString());
            } else {
                throw new Exception("Encryption Exception");
            }
        }
    }

    public ResponseEntity<?> sendPost(String url, Map<String, String> reqBodyMap, Class<?> valueType) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, String>> request = new HttpEntity<>(reqBodyMap, headers);
        ResponseEntity<?> responseEntity = this.restTemplate.postForEntity(url, request, valueType);
        return responseEntity;
    }
}