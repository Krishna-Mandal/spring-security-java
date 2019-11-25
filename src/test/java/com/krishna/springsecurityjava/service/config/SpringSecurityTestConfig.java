package com.krishna.springsecurityjava.service.config;

import com.krishna.springsecurityjava.models.User;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Arrays;

@TestConfiguration
public class SpringSecurityTestConfig {

    @Bean
    @Primary
    public UserDetailsService userDetailsService() {
        User basicUser = new User(1,"userr1","pass1",true, "ROLE_USER");
        UserDetails basicUserDetails = new JPAUserDetails(basicUser);

        User managerUser = new User(1,"userr3","pass3",true, "ROLE_USER,ROLE_ADMIN");
        UserDetails managerUserDetails = new JPAUserDetails(managerUser);

        return new InMemoryUserDetailsManager(Arrays.asList(
                basicUserDetails,
                managerUserDetails
        ));
    }
}
