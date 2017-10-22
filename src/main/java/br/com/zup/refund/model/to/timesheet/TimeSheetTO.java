package br.com.zup.refund.model.to.timesheet;


import br.com.zup.refund.model.employee.Employee;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class TimeSheetTO {

    private Long timeSheetId;

    
    private PrimaryInformationTO primaryInformationTO;

    private ClassificationTO classificationTO;

    private TimeSheetApprovalTO timeSheetApprovalTO;

    private Employee employee;
}
