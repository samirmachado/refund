package br.com.zup.refund.model;


import javax.persistence.*;

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
public class TimeSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long timeSheetId;

    @OneToOne(cascade = CascadeType.PERSIST)
    private PrimaryInformation primaryInformation;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Classification classification;

    @OneToOne(fetch = FetchType.EAGER)
    private TimeSheetApproval timeSheetApproval;

    @ManyToOne
    private Employee employee;
}
