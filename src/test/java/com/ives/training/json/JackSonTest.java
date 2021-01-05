package com.ives.training.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JackSonTest {

    @Autowired
    JackSon jackSon;
    @Test
    void jackSonTest() throws JsonProcessingException {
        jackSon.jackSonTest();
    }
}