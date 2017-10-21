package br.com.zup.refund.model.timesheet;

import br.com.zup.refund.model.employee.Employee;
import br.com.zup.refund.model.customerdata.CaseTaskEvent;
import br.com.zup.refund.model.customerdata.Customer;
import br.com.zup.refund.model.customerdata.ServiceItem;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class PrimaryInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Employee employee;

    private LocalDate date;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalTime duration;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private CaseTaskEvent caseTaskEvent;

    @ManyToOne
    private ServiceItem serviceItem;

    private Boolean billable;

    private String memo;

}
