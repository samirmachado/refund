package br.com.zup.refund.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.refund.model.User;
import br.com.zup.refund.model.to.UserTO;

@RestController
public class UserController extends MainController{
    
    private UserTO userTO = new UserTO();
    
    @GetMapping
    private ResponseEntity<?> hello() {
        User user = User.builder().id(1l).name("name").build();
        return responseCreated(userTO.map(user));
    }
}
