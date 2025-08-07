package com.helloboot;

import java.util.Objects;

public class HelloService {

    public String sayHello(String name) {
        return "Hello " + Objects.requireNonNull(name);
    }
}
