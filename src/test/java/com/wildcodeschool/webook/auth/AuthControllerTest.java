package com.wildcodeschool.webook.auth;

import com.wildcodeschool.webook.Auth.domain.entity.User;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-test.properties"
)
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private User user;

    @Test
    public void testRegister() throws Exception {
        JSONObject jo = new JSONObject();
        jo.put("username", "pie");
        jo.put("email", "apple@mail.com");
        jo.put("password", "applePie");
        jo.put("zip_code", 31300);
        jo.put("city", "toulouse");
        jo.put("is_enabled", true);

        mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/register")
                        .content(jo.toString())
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("pie"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("apple@mail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.zip_code").value(31300))
                .andExpect(MockMvcResultMatchers.jsonPath("$.city").value("toulouse"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.is_enabled").value(true));
    }
}
