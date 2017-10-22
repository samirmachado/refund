package br.com.zup.refund.model.to.timesheet;

import br.com.zup.refund.model.to.EmployeeTO;
import br.com.zup.refund.model.to.customerdata.CaseTaskEventTO;
import br.com.zup.refund.model.to.customerdata.CustomerTO;
import br.com.zup.refund.model.to.customerdata.ServiceItemTO;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class PrimaryInformationTO {

    private Long id;

    private EmployeeTO employee;

    private LocalDate date;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalTime duration;

    private CustomerTO customer;

    private CaseTaskEventTO caseTaskEvent;

    private ServiceItemTO serviceItem;

    private Boolean billable;

    private String memo;

}
