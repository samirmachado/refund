package br.com.zup.refund.model.to.customerdata;

import br.com.zup.refund.model.ConfigurationInformation;
import br.com.zup.refund.model.enuns.TaskEventType;
import br.com.zup.refund.model.timesheet.Classification;
import br.com.zup.refund.model.timesheet.PrimaryInformation;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class CaseTaskEventTO {

    private Long caseTaskEventId;

    private String name;

    private TaskEventType type;

    List<Classification> classifications;

    private List<PrimaryInformation> primaryInformations;

    private List<ConfigurationInformation> configurationInformation;
}
