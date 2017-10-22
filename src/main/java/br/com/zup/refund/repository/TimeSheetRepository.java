package br.com.zup.refund.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.refund.model.Employee;
import br.com.zup.refund.model.TimeSheet;

@Repository
public interface TimeSheetRepository extends JpaRepository<TimeSheet, Long>{

    List<TimeSheet> findByEmployee(Employee employee);
}
