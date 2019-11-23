package com.krishna.springsecurityjava;

import com.krishna.springsecurityjava.controller.repo.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class SpringSecurityJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJavaApplication.class, args);
	}

}
