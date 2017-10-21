package br.com.zup.refund.model.employee;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.zup.refund.model.enuns.EmployeeType;
import br.com.zup.refund.model.timesheet.PrimaryInformation;
import br.com.zup.refund.model.timesheet.TimeSheet;
import br.com.zup.refund.model.timesheet.TimeSheetApproval;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    
    @Column(unique=true)
    private String email;

    private String password;

    @OneToMany(mappedBy = "employee")
    private List<TimeSheet> timeSheets;

    //aprovações que fiz
    @OneToMany(mappedBy = "employee")
    private List<TimeSheetApproval> timeSheetApprovals;

    private EmployeeType employeeType;

    @OneToMany(mappedBy = "employee")
    private List<PrimaryInformation> primaryInformations;

}
