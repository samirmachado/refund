package br.com.zup.refund.model.to;

import java.util.List;

import br.com.zup.refund.model.ConfigurationInformation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
