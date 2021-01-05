package com.ives.training.webService.service;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @DESCRIPTION:
 * @USER: ives
 * @DATE: 2020/11/12 16:06
 */
@WebService
public interface MyService {
    @WebResult
    @WebMethod
    String show();
}
