package br.com.zup.refund.unit.TO;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import br.com.zup.refund.model.Employee;
import br.com.zup.refund.model.to.EmployeeTO;

public class MainTOTest {
    
    @Test
    public void shouldMapObject() {
        Employee employee = Employee.builder().id(1l).build();
        EmployeeTO employeeTO = new EmployeeTO().map(employee);
        assertEquals(employeeTO.getId(), employee.getId());
    }
    
    @Test
    public void shouldMapListOfObjects() {
        List<Employee> employees =  new ArrayList<Employee>(Arrays.asList(Employee.builder().id(1l).build()));
        List<EmployeeTO> employeeTOs = new EmployeeTO().mapList(employees);
        assertEquals(employeeTOs.size(), 1);
        assertEquals(employeeTOs.get(0).getId(), employees.get(0).getId());
    }
}
