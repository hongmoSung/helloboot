package com.helloboot;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HelloControllerTest {

    @Test
    void hello() {
        HelloController helloController = new HelloController(name -> name);
        String ret = helloController.hello("Test");
        assertThat(ret).isEqualTo("Test");
    }

    @Test
    void failHello() {
        HelloController helloController = new HelloController(name -> name);
        assertThatThrownBy(() -> helloController.hello("   ")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> helloController.hello("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> helloController.hello(null)).isInstanceOf(IllegalArgumentException.class);
    }
}
