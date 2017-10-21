package br.com.zup.refund.integration.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import br.com.zup.refund.MainIntegratedTest;
import br.com.zup.refund.model.employee.Employee;
import br.com.zup.refund.repository.EmployeeRepository;

public class AuthorizationControllerTest extends MainIntegratedTest{
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @After
    public void setup() throws Exception {
        clearDatabase();
    }
    
    @Test
    public void shouldLogin() throws Exception {
        Employee employee = Employee.builder().name("name").email("joao@email.com").password("senha").build();
        employeeRepository.save(employee);
        
        mockMvc.perform(post("/login")
            .content(mapper.writeValueAsString(employee)) 
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }
    
    @Test
    public void shouldNotLogin() throws Exception {
        Employee employee = Employee.builder().name("name").email("joao@email.com").password("senha").build();
        employeeRepository.save(employee);
        employee.setPassword("senha_errada");
        
        mockMvc.perform(post("/login")
            .content(mapper.writeValueAsString(employee)) 
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isUnauthorized());
    }
    
    @Test
    public void shouldLogout() throws Exception {
        Employee employee = Employee.builder().name("name").email("joao@email.com").password("senha").build();
        employeeRepository.save(employee);
        
        String token = mockMvc.perform(post("/login")
            .content(mapper.writeValueAsString(employee)) 
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk()).andReturn().getResponse().getHeader("token");
        
        mockMvc.perform(get("/logout")
                .contentType(MediaType.APPLICATION_JSON)
                .header("token", token))
                .andExpect(status().isOk());
        
        mockMvc.perform(get("/logout")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }
    
    @Test
    public void shouldNotLogout() throws Exception {
        Employee employee = Employee.builder().name("name").email("joao@email.com").password("senha").build();
        employeeRepository.save(employee);
        
        mockMvc.perform(get("/logout")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }
}
