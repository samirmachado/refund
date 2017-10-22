package br.com.zup.refund.model.to;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import br.com.zup.refund.model.util.LocalDateSerializer;
import br.com.zup.refund.model.util.LocalDateTimeSerializer;
import br.com.zup.refund.model.util.LocalTimeSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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

    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate date;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime startTime;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime endTime;

    @JsonSerialize(using = LocalTimeSerializer.class)
    private LocalTime duration;

    private CustomerTO customer;

    private CaseTaskEventTO caseTaskEvent;

    private ServiceItemTO serviceItem;

    private Boolean billable;

    private String memo;

}
