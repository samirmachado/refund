package br.com.zup.refund.session;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import br.com.zup.refund.model.Employee;
import br.com.zup.refund.repository.EmployeeRepository;

@ApplicationScope
@Component
public class Session {
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    Map<String, Employee> authorizeds = new HashMap<String, Employee>();

    public void setup(){
        Employee employee = employeeRepository.findByEmailAndPassword("teste@email.com", "pass");
        authorizeds.put("token", employee);
    }

    public Boolean checkAuthorization(String token) {
        setup();
        Employee loggedEmployee = authorizeds.get(token);
        return loggedEmployee!=null;
    }

    public String login(String email, String password) {
        Employee employee = employeeRepository.findByEmailAndPassword(email, password);
        if(employee!=null) {
            logout(email);
            String token = UUID.randomUUID().toString();
            
            authorizeds.put(token, Employee.builder()
                    .id(employee.getId())
                    .email(employee.getEmail())
                    .build());
            
            return token;
        }
        return null;
    }
    
    public Employee getLoggedEmployee(String token) {
        return authorizeds.get(token);
    }

    public void logout(String email) {
        String token=null;
        
        for (Map.Entry<String, Employee> entry : authorizeds.entrySet()) {
            String employeeToken = entry.getKey();
            Employee employee = entry.getValue();
            if(employee.getEmail().equals(email)){
                token = employeeToken;
                break;
            }
        }
        
        if(StringUtils.isNoneBlank(token)) {
            authorizeds.remove(token);
        }
    }
}
