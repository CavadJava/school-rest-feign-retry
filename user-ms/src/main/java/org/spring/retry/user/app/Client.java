package org.spring.retry.user.app;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "user-api",
        url = "${client.feign.base-url}",
        configuration = UserClientConfiguration.class)
public interface Client {

    @GetMapping("/check-health")
    String checkHealth();

}
