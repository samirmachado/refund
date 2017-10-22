package br.com.zup.refund.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import br.com.zup.refund.model.enuns.TaskEventType;
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
public class CaseTaskEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long caseTaskEventId;

    private String name;

    @Enumerated(EnumType.STRING)
    private TaskEventType type;

    @OneToMany(mappedBy = "caseTaskEvent")
    List<Classification> classifications;

    @OneToMany(mappedBy = "caseTaskEvent")
    private List<PrimaryInformation> primaryInformations;

    @ManyToMany(mappedBy = "caseTaskEvent")
    private List<ConfigurationInformation> configurationInformation;
}
