package br.com.zup.refund.model.to;


import br.com.zup.refund.model.Employee;
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
public class TimeSheetTO {

    private Long timeSheetId;

    
    private PrimaryInformationTO primaryInformationTO;

    private ClassificationTO classificationTO;

    private TimeSheetApprovalTO timeSheetApprovalTO;

    private Employee employee;
}
