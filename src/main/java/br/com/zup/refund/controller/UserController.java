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
@RequestMapping("/user")
public class UserController extends MainController{
    
    private UserTO userTO = new UserTO();
    
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping
    private ResponseEntity<?> hello() {
        User user = User.builder().id(1l).name("name").build();
        return responseCreated(userTO.map(user));
    }
    
    @PostMapping("save-user")
    private ResponseEntity<?> post() {
        User user = User.builder().id(1l).name("name").build();
        user = userRepository.save(user);
        return responseCreated(userTO.map(user));
    }
    
    @GetMapping("list-users")
    private ResponseEntity<?> list() {
        List<User> users = userRepository.findAll();
        return responseCreated(userTO.mapList(users));
    }
}
