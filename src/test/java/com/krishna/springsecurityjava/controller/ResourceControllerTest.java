package com.krishna.springsecurityjava.controller;

import com.krishna.springsecurityjava.service.config.SpringSecurityTestConfig;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = SpringSecurityTestConfig.class
)

@AutoConfigureMockMvc
class ResourceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void home() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/")
                .accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Welcome")));

    }

    @Test
    @WithAnonymousUser
    void userWithAnonymousUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user")
                .accept(MediaType.ALL))
                .andExpect(status().isFound());
    }

    @Test
    @WithUserDetails("userr1")
    void userWithActualUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user")
                .accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("userr1")));
    }

    @Test
    @WithMockUser(roles = "USER")
    void adminNoAdminRights() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin")
                .accept(MediaType.ALL))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void adminAdminRights() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin")
                .accept(MediaType.ALL))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("admin")));
    }
}