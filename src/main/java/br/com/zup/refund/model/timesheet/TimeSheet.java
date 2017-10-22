package br.com.zup.refund.model.timesheet;


import br.com.zup.refund.model.employee.Employee;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class TimeSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long timeSheetId;

    @OneToOne
    private PrimaryInformation primaryInformation;

    @OneToOne
    private Classification classification;

    @OneToOne(fetch = FetchType.EAGER)
    private TimeSheetApproval timeSheetApproval;

    @ManyToOne
    private Employee employee;
}
