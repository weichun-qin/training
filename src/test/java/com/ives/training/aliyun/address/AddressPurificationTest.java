package com.ives.training.aliyun.address;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddressPurificationTest {

    @Autowired
    AddressPurification addressPurification;
    @Test
    void addressPurification() {
        addressPurification.addressPurification("安徽省蚌埠市怀远县城关镇苏果超市4楼");
    }
}