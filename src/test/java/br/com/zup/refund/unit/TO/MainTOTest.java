package br.com.zup.refund.unit.TO;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.zup.refund.model.employee.Employee;
import org.junit.Test;

import br.com.zup.refund.model.to.UserTO;

public class MainTOTest {
    
    @Test
    public void shouldMapObject() {
        Employee employee = Employee.builder().id(1l).build();
        UserTO userTO = new UserTO().map(employee);
        assertEquals(userTO.getId(), employee.getId());
    }
    
    @Test
    public void shouldMapListOfObjects() {
        List<Employee> employees =  new ArrayList<Employee>(Arrays.asList(Employee.builder().id(1l).build()));
        List<UserTO> userTOs = new UserTO().mapList(employees);
        assertEquals(userTOs.size(), 1);
        assertEquals(userTOs.get(0).getId(), employees.get(0).getId());
    }
}
