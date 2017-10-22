package br.com.zup.refund.model.to;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
