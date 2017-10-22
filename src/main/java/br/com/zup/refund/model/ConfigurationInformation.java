package br.com.zup.refund.model;

import br.com.zup.refund.model.customerdata.*;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class ConfigurationInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Customer> customer;

    @OneToMany(fetch = FetchType.LAZY)
    private List<CaseTaskEvent> caseTaskEvent;

    @OneToMany(fetch = FetchType.LAZY)
    private List<ServiceItem> serviceItem;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Subsidiary> subsidiary;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Clasz> clasz;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Location> location;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Department> department;


}
