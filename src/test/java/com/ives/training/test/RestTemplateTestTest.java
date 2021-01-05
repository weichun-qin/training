package com.ives.training.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestTemplateTestTest {

    @Autowired
    RestTemplateTest restTemplateTest;

    @Test
    void encryption() throws Exception {
        byte[] bytes = "123456".getBytes();
        restTemplateTest.encryption(bytes);
    }
}