package javamentor.examples.springcloudeurekaclient.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Value("${greeting-message}")
    private String greetingMessage;

    @GetMapping("/hello")
    public String hello() {
        return greetingMessage;
    }

}
