package com.krishna.springsecurityjava.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    @GetMapping(path = "/")
    public String home() {

        return ("Welcome Home");
    }

    @GetMapping(path = "/user")
    public String user() {

        return ("Welcome user : Krishna");
    }

    @GetMapping(path = "/admin")
    public String admin() {

        return ("Welcome admin");
    }
}
