package com.ives.training.webService.service.impl;

import com.ives.training.webService.service.MyService;

import javax.jws.WebService;

/**
 * @DESCRIPTION:
 * @USER: ives
 * @DATE: 2020/11/12 16:07
 */
@WebService(endpointInterface = "com.ives.training.webService.service.MyService")
public class MyServiceImpl implements MyService {
    @Override
    public String show() {
        System.out.println("MyServiceImpl中的show方法被调用！");
        return "【调用成功！】";
    }
}
