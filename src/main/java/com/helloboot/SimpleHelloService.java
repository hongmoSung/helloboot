package com.helloboot;

import java.util.Objects;

public class SimpleHelloService implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello " + Objects.requireNonNull(name);
    }
}
