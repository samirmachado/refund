package br.com.zup.refund.model.to;

import br.com.zup.refund.model.ConfigurationInformation;
import br.com.zup.refund.model.to.customerdata.*;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class ConfigurationInformationTO extends MainTO<ConfigurationInformationTO, ConfigurationInformation> {

    private Long id;

    
    private List<CustomerTO> customer;

    
    private List<CaseTaskEventTO> caseTaskEvent;

    
    private List<ServiceItemTO> serviceItem;

    
    private List<SubsidiaryTO> subsidiary;

    
    private List<ClaszTO> clasz;

    
    private List<LocationTO> location;

    
    private List<DepartmentTO> department;


}
