package com.helloboot;

import java.util.Objects;

public class HelloController {

    public String hello(String name) {
        HelloService helloService = new HelloService();
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
