package br.com.zup.refund.model.timesheet;

import br.com.zup.refund.model.employee.Employee;
import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class TimeSheetApproval {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private TimeSheet timeSheet;

    @Range(min = 1, max = 2)
    private Long status;

    private String memo;

    //o cara q aprovou
    @ManyToOne
    private Employee employee;
}
