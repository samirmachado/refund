package br.com.zup.refund.session;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import br.com.zup.refund.model.User;
import br.com.zup.refund.repository.UserRepository;

@ApplicationScope
@Component
public class Session {
    
    @Autowired
    private UserRepository userRepository;
    
    Map<String, User> authorizeds = new HashMap<String, User>();
    
    public Boolean checkAuthorization(String token) {
        User loggedUser = authorizeds.get(token);
        return loggedUser!=null;
    }

    public String login(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        if(user!=null) {
            logout(email);
            String token = UUID.randomUUID().toString();
            
            authorizeds.put(token, User.builder()
                    .id(user.getId())
                    .email(user.getEmail())
                    .build());
            
            return token;
        }
        return null;
    }
    
    public User getLoggedUser(String token) {
        return authorizeds.get(token);
    }

    public void logout(String email) {
        String token=null;
        
        for (Map.Entry<String, User> entry : authorizeds.entrySet()) {
            String userToken = entry.getKey();
            User user = entry.getValue();
            if(user.getEmail().equals(email)){
                token = userToken;
                break;
            }
        }
        
        if(StringUtils.isNoneBlank(token)) {
            authorizeds.remove(token);
        }
    }
}
