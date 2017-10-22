package br.com.zup.refund.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
public class PrimaryInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Employee employee;

    private LocalDate date;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalTime duration;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private CaseTaskEvent caseTaskEvent;

    @ManyToOne
    private ServiceItem serviceItem;

    private Boolean billable;

    private String memo;

}
