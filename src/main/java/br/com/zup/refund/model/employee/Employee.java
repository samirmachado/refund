package br.com.zup.refund.model.employee;

import java.util.List;

import javax.persistence.*;

import br.com.zup.refund.model.enuns.EmployeeType;
import br.com.zup.refund.model.timesheet.PrimaryInformation;
import br.com.zup.refund.model.timesheet.TimeSheet;
import br.com.zup.refund.model.timesheet.TimeSheetApproval;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    @Enumerated(value = EnumType.STRING)
    private EmployeeType employeeType;

    @OneToMany(mappedBy = "employee")
    private List<PrimaryInformation> primaryInformations;

}
