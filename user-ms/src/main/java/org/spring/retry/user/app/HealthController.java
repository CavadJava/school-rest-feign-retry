package org.spring.retry.user.app;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/health")
public class HealthController {
    private final Client adaptorClient;
    @GetMapping
    public String check() {
        return adaptorClient.checkHealth();
    }
}
