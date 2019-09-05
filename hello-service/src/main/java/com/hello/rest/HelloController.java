package com.hello.rest;

import com.hello.service.HelloService;
import io.opentracing.Span;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("hello")
public class HelloController {

    @Autowired
    private Tracer tracer;
    
    @Autowired 
    private RestTemplate template;
    

    private final HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/get")
    public String getHello() {
        Span span = tracer.buildSpan("HelloController getHello").start();
        String result = "Hello from hello-service";
        span.finish();
        return result;
    }
    
    @GetMapping("/chaining")
    public String getChain() {
    	ResponseEntity<String> response = template.getForEntity("http://localhost:8200/hello/get", String.class);
        return "Chaining + " + response.getBody();
    	
    }
}
