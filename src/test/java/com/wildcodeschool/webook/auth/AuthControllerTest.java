package com.wildcodeschool.webook.auth;

import com.wildcodeschool.webook.Auth.domain.entity.User;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private User user;

    public String userData() throws Exception {
        JSONObject jo = new JSONObject();
        jo.put("username", "pie");
        jo.put("email", "apple@mail.com");
        jo.put("password", "applePie");
        jo.put("zip_code", "31300");
        jo.put("city", "toulouse");
        jo.put("is_enabled", true);

        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.post("/register")
                        .content(jo.toString())
                        .contentType(MediaType.APPLICATION_JSON));

        MvcResult result = resultActions.andReturn();
        return result.getResponse().getContentAsString();
    }

    @Test
    public void testRegister() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/register")
                        .content(userData())
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
