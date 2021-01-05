package com.ives.training.test;

import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @DESCRIPTION:
 * @USER: ives
 * @DATE: 2020/12/1 14:46
 */
@Component
public class Test {

    public void anyOnTest() throws UnsupportedEncodingException {
        String ControlByte = "189hjkdsa";
        byte[] bytes = ControlByte.getBytes("UTF-8");
        String en = new String(bytes);
        String en2=bytes.toString();
        //String tstr = "" + Long.parseLong(ControlByte, 16);
        String enString = "8d48214356d<iv>jdi1028ujk";
        List<byte[]> list=getCipherTextAndIV(enString);
        String s = new String(list.get(0));
        String r = new String(list.get(1));
        String t = "123456";
        String servCode =t.substring(t.length() - 4);
        System.out.println(servCode);
    }

    public static List<byte[]> getCipherTextAndIV(String cipher){
        List<byte[]> bytes = new ArrayList<>();
        byte[] cipherText = cipher.substring(0,cipher.indexOf("<iv>")).getBytes();
        byte[] iv = cipher.substring(cipher.indexOf("<iv>")+4,cipher.length()).getBytes();
        bytes.add(cipherText);
        bytes.add(iv);
        return bytes;
    }
}
