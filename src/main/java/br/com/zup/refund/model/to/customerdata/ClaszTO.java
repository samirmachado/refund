package br.com.zup.refund.model.to.customerdata;

import br.com.zup.refund.model.ConfigurationInformation;
import br.com.zup.refund.model.timesheet.Classification;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class ClaszTO {


    private Long classId;

    private String name;

    List<Classification> classifications;

    private List<ConfigurationInformation> configurationInformation;
}
