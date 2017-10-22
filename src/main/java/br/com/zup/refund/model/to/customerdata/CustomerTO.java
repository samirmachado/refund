package br.com.zup.refund.model.to.customerdata;

import br.com.zup.refund.model.ConfigurationInformation;
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
public class CustomerTO {

    private Long customerId;

    private String name;

    private List<PrimaryInformation> primaryInformations;

    private List<ConfigurationInformation> configurationInformation;
}
