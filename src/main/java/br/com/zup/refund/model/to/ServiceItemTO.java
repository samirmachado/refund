package br.com.zup.refund.model.to;

import java.util.List;

import br.com.zup.refund.model.ConfigurationInformation;
import br.com.zup.refund.model.PrimaryInformation;
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
public class ServiceItemTO {

    private Long itemId;

    private String description;

    private List<PrimaryInformation> primaryInformations;

    private List<ConfigurationInformation> configurationInformation;

}
