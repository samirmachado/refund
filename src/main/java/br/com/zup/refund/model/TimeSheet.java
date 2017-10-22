package br.com.zup.refund.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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

    @OneToOne
    private PrimaryInformation primaryInformation;

    @OneToOne
    private Classification classification;

    @OneToOne(fetch = FetchType.EAGER)
    private TimeSheetApproval timeSheetApproval;

    @ManyToOne
    private Employee employee;
}
