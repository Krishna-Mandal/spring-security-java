package com.krishna.springsecurityjava.controller;

import javax.validation.Valid;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.krishna.springsecurityjava.models.UserForm;

@Controller
public class ResourceController {

    @GetMapping(path = "/", consumes = MediaType.ALL_VALUE)
    public String home() {

        return "index";
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

    @GetMapping(path = "/register")
    public String showForm(UserForm userForm) {
        return "form";
    }

    @PostMapping(path = "/register")
    public String checkUserInfo(@Valid UserForm userForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        return "redirect:/results";
    }

}
