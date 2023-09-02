package com.helloboot;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloServiceTest {

    @Test
    void sayHello() {
        HelloService helloService = new SimpleHelloService();
        String ret = helloService.sayHello("Test");
        assertThat(ret).isEqualTo("Hello Test");
    }
}
