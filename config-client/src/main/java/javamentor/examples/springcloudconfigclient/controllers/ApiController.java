package javamentor.examples.springcloudconfigclient.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ApiController {

    @Value("${message}")
    private String testProperty;

    @GetMapping("/hello")
    public String hello() {
        return testProperty;
    }

}
