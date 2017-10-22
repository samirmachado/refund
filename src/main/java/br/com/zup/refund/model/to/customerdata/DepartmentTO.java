package br.com.zup.refund.model.to.customerdata;

import br.com.zup.refund.model.ConfigurationInformation;
import br.com.zup.refund.model.timesheet.Classification;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class DepartmentTO {

    private Long departmentId;

    private String name;

    List<Classification> classifications;

    private List<ConfigurationInformation> configurationInformation;
}
