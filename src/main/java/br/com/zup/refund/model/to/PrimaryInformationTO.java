package br.com.zup.refund.model.to;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
