package br.com.zup.refund.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "configuration__customer", joinColumns = { @JoinColumn(name = "id") }
        , inverseJoinColumns = { @JoinColumn(name = "customerId") })
    private List<Customer> customer;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "configuration__caseTaskEvent", joinColumns = { @JoinColumn(name = "id") }
        , inverseJoinColumns = { @JoinColumn(name = "caseTaskEventId") })
    private List<CaseTaskEvent> caseTaskEvent;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "configuration__serviceItem", joinColumns = { @JoinColumn(name = "id") }
        , inverseJoinColumns = { @JoinColumn(name = "itemId") })
    private List<ServiceItem> serviceItem;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "configuration__subsidiary", joinColumns = { @JoinColumn(name = "id") }
        , inverseJoinColumns = { @JoinColumn(name = "subsidiaryId") })
    private List<Subsidiary> subsidiary;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "configuration__clasz", joinColumns = { @JoinColumn(name = "id") }
        , inverseJoinColumns = { @JoinColumn(name = "classId") })
    private List<Clasz> clasz;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "configuration__location", joinColumns = { @JoinColumn(name = "id") }
        , inverseJoinColumns = { @JoinColumn(name = "locationId") })
    private List<Location> location;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "configuration__department", joinColumns = { @JoinColumn(name = "id") }
        , inverseJoinColumns = { @JoinColumn(name = "departmentId") })
    private List<Department> department;

}
