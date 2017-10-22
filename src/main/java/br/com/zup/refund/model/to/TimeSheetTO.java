package br.com.zup.refund.model.to;


import br.com.zup.refund.model.ConfigurationInformation;
import br.com.zup.refund.model.Employee;
import br.com.zup.refund.model.TimeSheet;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class TimeSheetTO extends MainTO<TimeSheetTO, TimeSheet> {

    private Long timeSheetId;

    private PrimaryInformationTO primaryInformation;

    private ClassificationTO classification;

    private TimeSheetApprovalTO timeSheetApproval;

    private EmployeeTO employee;
}
