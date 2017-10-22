package br.com.zup.refund.model.to.timesheet;

import br.com.zup.refund.model.to.customerdata.*;
import lombok.*;

import javax.persistence.Entity;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class ClassificationTO {

    private Long id;

   
    private SubsidiaryTO subsidiary;

   
    private ClaszTO clasz;

   
    private LocationTO location;

   
    private DepartmentTO department;

   
    private CaseTaskEventTO caseTaskEvent;

}
