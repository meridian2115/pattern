package com.service.car.controller;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = TestRestController.class, excludeAutoConfiguration = {SecurityAutoConfiguration.class})
class TestRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testApi() throws Exception {
        MvcResult mvcResult = mockMvc
                .perform(get("/api/v1"))
                .andExpect(status().isOk())
                .andReturn();
        String contentType = mvcResult.getResponse().getContentType();
        assertEquals(MediaType.APPLICATION_JSON_VALUE, contentType);
        String content = mvcResult.getResponse().getContentAsString();
        assertThat(content, CoreMatchers.containsString("value"));

    }

}