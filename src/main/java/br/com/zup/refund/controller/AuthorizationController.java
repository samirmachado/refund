package br.com.zup.refund.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.refund.model.User;
import br.com.zup.refund.session.Session;

@RestController
public class AuthorizationController extends MainController{
    
    @Autowired
    private Session session;
    
    @PostMapping
    private ResponseEntity<?> login(@RequestBody User user) {
        if(StringUtils.isNoneBlank(user.getEmail()) && StringUtils.isNoneBlank(user.getPassword())) {
            String loginToken = session.login(user.getEmail(), user.getPassword());
            if(loginToken!=null) {
                HttpHeaders headers = new HttpHeaders();
                headers.add("token", loginToken);
                return new ResponseEntity<>(headers, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
    
    @GetMapping
    private ResponseEntity<?> logout(HttpServletRequest request) {
        User user = session.getLoggedUser(request.getHeader("token"));
        if(user==null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        session.logout(user.getEmail());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
