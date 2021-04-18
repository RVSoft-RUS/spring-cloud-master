package javamentor.examples.eurekadiscovery.services;

import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    private final CircuitBreaker circuitBreaker;
    private final RestTemplate restTemplate;

    public HelloService(CircuitBreakerFactory<?, ?> circuitBreakerFactory,
                        RestTemplate restTemplate) {
        this.circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
        this.restTemplate = restTemplate;
    }

    public String hello() {
        return circuitBreaker.run(() -> restTemplate.getForObject("http://HELLO-SERVICE/hello", String.class), throwable -> "OOPS!");
    }

}
