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

import br.com.zup.refund.model.Employee;
import br.com.zup.refund.session.Session;

@RestController
public class AuthorizationController extends MainController{
    
    @Autowired
    private Session session;
    
    @PostMapping
    private ResponseEntity<?> login(@RequestBody Employee employee) {
        if(StringUtils.isNoneBlank(employee.getEmail()) && StringUtils.isNoneBlank(employee.getPassword())) {
            String loginToken = session.login(employee.getEmail(), employee.getPassword());
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
        Employee employee = session.getLoggedEmployee(request.getHeader("token"));
        if(employee==null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        session.logout(employee.getEmail());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
