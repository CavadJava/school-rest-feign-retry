package org.spring.retry.user.app;

import feign.RetryableException;
import feign.Retryer;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@NoArgsConstructor
public class CustomRetryer implements Retryer {

    private int retryMaxAttempt;

    private long retryInterval;

    private int attempt=1;


    public CustomRetryer(int retryMaxAttempt, Long retryInterval) {
        this.retryMaxAttempt = retryMaxAttempt;
        this.retryInterval = retryInterval;
    }

    @Override
    public void continueOrPropagate(RetryableException e) {
        log.info("Feign retry attempt {} due to {} ", attempt, e.getMessage());

        if(attempt++ == retryMaxAttempt){
            throw new UserNotFoundException();
        }
        try {
            System.out.println("attempt:"+attempt);
            Thread.sleep(retryInterval);
        } catch (InterruptedException ignored) {
            Thread.currentThread().interrupt();
        }

    }

    @Override
    public Retryer clone() {
        return new CustomRetryer(6,2000L);
    }
}