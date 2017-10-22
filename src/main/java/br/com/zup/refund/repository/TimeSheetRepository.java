package br.com.zup.refund.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.zup.refund.model.Employee;
import br.com.zup.refund.model.TimeSheet;

@Repository
public interface TimeSheetRepository extends JpaRepository<TimeSheet, Long>{

    List<TimeSheet> findByEmployee(Employee employee);
    
    @Query("select ts from TimeSheet ts "
            + "join ts.classification c "
            + "join c.department d "
            + "join d.manager m "
            + "where m.id = :managerId and ts.timeSheetApproval is null")
    List<TimeSheet> findTimeSheetsOfManager(@Param("managerId") Long managerId);
}
