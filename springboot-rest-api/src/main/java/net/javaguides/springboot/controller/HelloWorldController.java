package net.javaguides.springboot.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    //Http Get Request
    //http://localhost:8090/hello-world
    @GetMapping("/hello-world")
    public String helloworld(){
        return "hello world";
    }
}
