package br.com.zup.refund.model.customerdata;

import br.com.zup.refund.model.ConfigurationInformation;
import br.com.zup.refund.model.employee.Employee;
import br.com.zup.refund.model.timesheet.PrimaryInformation;
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
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;

    private String name;

    @OneToMany(mappedBy = "customer")
    private List<PrimaryInformation> primaryInformations;

    @OneToMany(mappedBy = "customer")
    private List<ConfigurationInformation> configurationInformation;
}
