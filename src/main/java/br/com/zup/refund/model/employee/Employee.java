package br.com.zup.refund.model.employee;

import javax.persistence.*;

import br.com.zup.refund.model.enuns.UserType;
import br.com.zup.refund.model.timesheet.PrimaryInformation;
import br.com.zup.refund.model.timesheet.TimeSheetApproval;
import br.com.zup.refund.model.timesheet.TimeSheet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    private UserType userType;

    @OneToMany(mappedBy = "employee")
    private List<PrimaryInformation> primaryInformations;

}
