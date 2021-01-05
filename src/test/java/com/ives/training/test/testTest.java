package com.ives.training.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class testTest {

    @Autowired
    com.ives.training.test.Test test;
    @Test
    void test() throws UnsupportedEncodingException {
        test.anyOnTest();
    }
}