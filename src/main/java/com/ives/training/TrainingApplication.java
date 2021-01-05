package com.ives.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Endpoint;

@RestController
@SpringBootApplication
public class TrainingApplication {

    @Autowired
    Endpoint endpoint;

    @RequestMapping
    public String testEndpoint() {
        //org.apache.tomcat.websocket.pojo.PojoEndpointServer@6a8cd4c7
        return endpoint.toString();
    }
    public static void main(String[] args) {
        SpringApplication.run(TrainingApplication.class, args);
    }

}
