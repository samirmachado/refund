package br.com.zup.refund.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.refund.model.to.EmployeeTO;
import br.com.zup.refund.repository.EmployeeRepository;

@RestController
public class EmployeeController extends MainController{
    
    private EmployeeTO employeeTO = new EmployeeTO();
    
    @Autowired
    private EmployeeRepository employeeRepository;

}
