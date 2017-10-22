package br.com.zup.refund.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.zup.refund.model.enuns.EmployeeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    
  //departamentos do gestor
    @OneToMany(mappedBy = "manager")
    private List<Department> departments;

    @Enumerated(value = EnumType.STRING)
    private EmployeeType employeeType;

    @OneToMany(mappedBy = "employee")
    private List<PrimaryInformation> primaryInformations;

}
