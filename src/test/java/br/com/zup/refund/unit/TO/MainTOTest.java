package br.com.zup.refund.unit.TO;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import br.com.zup.refund.model.User;
import br.com.zup.refund.model.to.UserTO;

public class MainTOTest {
    
    @Test
    public void shouldMapObject() {
        User user = User.builder().id(1l).build();
        UserTO userTO = new UserTO().map(user);
        assertEquals(userTO.getId(), user.getId());
    }
    
    @Test
    public void shouldMapListOfObjects() {
        List<User> users =  new ArrayList<User>(Arrays.asList(User.builder().id(1l).build()));
        List<UserTO> userTOs = new UserTO().mapList(users);
        assertEquals(userTOs.size(), 1);
        assertEquals(userTOs.get(0).getId(), users.get(0).getId());
    }
}
