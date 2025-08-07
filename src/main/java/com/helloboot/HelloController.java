package com.helloboot;

public class HelloController {

    public String hello(String name) {
        HelloService helloService = new HelloService();
        return helloService.sayHello(name);
    }
}
