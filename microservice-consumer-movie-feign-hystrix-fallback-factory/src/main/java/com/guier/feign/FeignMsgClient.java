package com.guier.feign;

import com.guier.dao.User;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(name = "microservice-provider-user", fallbackFactory = FeignMsgClientFallbackFactory.class)
public interface FeignMsgClient {
    @GetMapping("/users/{id}")
    User findById(@PathVariable("id") Long id);
}

@Component
@Slf4j
class FeignMsgClientFallbackFactory implements FallbackFactory<FeignMsgClient> {
    @Override
    public FeignMsgClient create(Throwable throwable) {
        return new FeignMsgClient() {
            @Override
            public User findById(Long id) {
                log.error("进入回退逻辑", throwable);
                return new User(id, "默认用户", "默认用户", 0, new BigDecimal(1));
            }
        };
    }
}