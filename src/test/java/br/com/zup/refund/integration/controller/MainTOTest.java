package br.com.zup.refund.integration.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import br.com.zup.refund.MainIntegratedTest;
import br.com.zup.refund.repository.EmployeeRepository;

public class MainTOTest extends MainIntegratedTest{
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @After
    public void setup() throws Exception {
        clearDatabase();
    }
    
    @Test
    public void shouldTest() throws Exception {
        mockMvc.perform(get("/hello").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
    }
}
