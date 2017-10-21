package br.com.zup.refund.model.timesheet;

import br.com.zup.refund.model.customerdata.*;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class Classification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Subsidiary subsidiary;

    @ManyToOne
    private Clasz clasz;

    @ManyToOne
    private Location location;

    @ManyToOne
    private Department department;

    @ManyToOne
    private CaseTaskEvent caseTaskEvent;

}
