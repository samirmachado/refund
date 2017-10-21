package br.com.zup.refund.controller;

import br.com.zup.refund.model.to.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.refund.repository.UserRepository;

@RestController
public class UserController extends MainController{
    
    private UserTO userTO = new UserTO();
    
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    private String hello() {
       return "hello";
    }

}
