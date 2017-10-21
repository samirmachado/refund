package br.com.zup.refund.model.customerdata;

import br.com.zup.refund.model.enuns.TaskEventType;
import br.com.zup.refund.model.timesheet.Classification;
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
}
