package br.com.zup.refund.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.refund.model.User;
import br.com.zup.refund.model.to.UserTO;
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
