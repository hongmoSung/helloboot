package com.helloboot.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CounterController {

    @Autowired
    private ApplicationContext context;

    @GetMapping("/singleton-test")
    public Map<String, Integer> testSingleton() {
        SingletonCounter counter1 = context.getBean(SingletonCounter.class);
        SingletonCounter counter2 = context.getBean(SingletonCounter.class);

        counter1.increment();
        counter1.increment();

        Map<String, Integer> result = new HashMap<>();
        result.put("counter1", counter1.getCount()); // 2
        result.put("counter2", counter2.getCount()); // 2 (같은 인스턴스)
        result.put("sameInstance", counter1 == counter2 ? 1 : 0); // 1

        return result;
    }

    @GetMapping("/prototype-test")
    public Map<String, Integer> testPrototype() {
        PrototypeCounter counter1 = context.getBean(PrototypeCounter.class);
        PrototypeCounter counter2 = context.getBean(PrototypeCounter.class);

        counter1.increment();
        counter1.increment();
        counter2.increment();

        Map<String, Integer> result = new HashMap<>();
        result.put("counter1", counter1.getCount()); // 2
        result.put("counter2", counter2.getCount()); // 1 (다른 인스턴스)
        result.put("sameInstance", counter1 == counter2 ? 1 : 0); // 0

        return result;
    }
}