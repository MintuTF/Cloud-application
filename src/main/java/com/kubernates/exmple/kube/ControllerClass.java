package com.kubernates.exmple.kube;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ControllerClass {

    @GetMapping("/hello")
    public String hello() {
        return "Hello - Jhooq-k8s";
    }
}
