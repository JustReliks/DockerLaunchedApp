package org.dockerlaunched.controllers;

import lombok.RequiredArgsConstructor;
import org.dockerlaunched.EnvConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@RequiredArgsConstructor
public class HelloController {

    private final EnvConfig envConfig;

    @GetMapping("/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello, %s, ENV PROPERTY: %s".formatted(name, envConfig.getEnvProperty());
    }
}
