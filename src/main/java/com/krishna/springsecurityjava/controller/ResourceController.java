package com.krishna.springsecurityjava.controller;

import com.krishna.springsecurityjava.models.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    @GetMapping(path = "/")
    public String home() {

        return ("Welcome Home");
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping(path = "/user")
    public String user(@NotNull @AuthenticationPrincipal UserDetails user) {

        return ("Welcome user : "+user.getUsername());
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(path = "/admin")
    public String admin(@NotNull @AuthenticationPrincipal UserDetails user) {

        return ("Welcome admin : "+user.getUsername());
    }
}
