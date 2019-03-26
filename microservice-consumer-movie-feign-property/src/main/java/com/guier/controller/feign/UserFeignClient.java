package com.guier.feign;

import com.guier.dao.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "microservice-provider-user", configuration = UserFeignConfig.class)
@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient {
    @GetMapping("/users/{id}")
    User findById(@PathVariable("id") Long id);
}

//class UserFeignConfig {
//
//    @Bean
//    public Logger.Level logger() {
//        return Logger.Level.FULL;
//    }
//
//}