package com.thoughtworks.mstorderservice.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("mst-users-service")
public interface UserClient {

    @GetMapping("/api/user/{userName}/address")
    String getUserAddress(@PathVariable String userName);
}
