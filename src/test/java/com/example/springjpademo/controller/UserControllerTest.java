package com.example.springjpademo.controller;

import com.example.springjpademo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(controllers = UserController.class)
@AutoConfigureMockMvc(addFilters = false) // surpass spring security
@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void createUserReturnCreated() throws Exception{
        String userJson  = "{" +
                "  \"name\": \"John Doe\"," +
                "  \"working\": true," +
                "  \"aboutMe\": \"I'm a passionate individual.\"," +
                "  \"age\": 19," +
                "  \"email\": \"john@example.com\"" +
                "}";
        mockMvc.perform(post("/api/v1/user")
                        .contentType(MediaType.APPLICATION_JSON)
                .content(userJson)
        ).andExpect(MockMvcResultMatchers.status().isCreated());
    }
}
