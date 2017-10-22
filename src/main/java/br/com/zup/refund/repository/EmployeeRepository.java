package br.com.zup.refund.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.refund.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

    Employee findByEmailAndPassword(String email, String password);
}
