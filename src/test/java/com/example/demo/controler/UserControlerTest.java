package com.example.demo.controler;

import com.example.demo.config.UserUrl;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControlerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserServiceImpl userService;


    @Test
    public void getUserExpensesTest() throws Exception {

        String spectedResult = "{\"totalExpenses\":30}";

        Mockito.when(userService.getTotalExpensesByUser(Mockito.anyString())).thenReturn(new BigDecimal("30"));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get(UserUrl.USER_EXPENSES)
                .contentType(MediaType.APPLICATION_JSON)
                .param("userName", "NAME"))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        assertEquals(content, spectedResult);
    }
}