package br.com.zup.refund.model.to.timesheet;

import br.com.zup.refund.model.to.EmployeeTO;
import lombok.*;

import javax.persistence.Entity;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class TimeSheetApprovalTO {

    private Long id;

    private TimeSheetTO timeSheetTO;

    private Long status;

    private String memo;

    //o cara q aprovou
    private EmployeeTO employee;
}
