package com.ives.training.webService.config;

import com.ives.training.webService.service.MyService;
import com.ives.training.webService.service.impl.MyServiceImpl;
import com.sun.xml.internal.ws.transport.http.server.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;


/**
 * @DESCRIPTION:
 * @USER: ives
 * @DATE: 2020/11/12 16:04
 */
@Configuration
public class WebServiceConfig {

    @Bean
    public Endpoint getEndpoint(){
        MyService serviceImpl=new MyServiceImpl();
        Endpoint publish = EndpointImpl.publish("http://localhost:9999/show",serviceImpl);
        return publish;
    }
}
