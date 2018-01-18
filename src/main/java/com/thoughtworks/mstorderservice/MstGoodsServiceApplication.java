package com.thoughtworks.mstorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MstGoodsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MstGoodsServiceApplication.class, args);
    }
}
