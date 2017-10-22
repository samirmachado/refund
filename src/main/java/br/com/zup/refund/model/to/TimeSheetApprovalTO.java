package br.com.zup.refund.model.to;

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
public class TimeSheetApprovalTO {

    private Long id;

    private TimeSheetTO timeSheetTO;

    private Long status;

    private String memo;

    //o cara q aprovou
    private EmployeeTO employee;
}
