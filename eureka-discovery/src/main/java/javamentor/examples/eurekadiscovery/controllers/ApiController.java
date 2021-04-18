package javamentor.examples.eurekadiscovery.controllers;

import javamentor.examples.eurekadiscovery.services.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    private final HelloService helloService;

    public ApiController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String proxy() {
        return helloService.hello();
    }

}
