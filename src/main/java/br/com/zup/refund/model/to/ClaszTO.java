package br.com.zup.refund.model.to;

import java.util.List;

import br.com.zup.refund.model.Classification;
import br.com.zup.refund.model.ConfigurationInformation;
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
public class ClaszTO {


    private Long classId;

    private String name;

    List<Classification> classifications;

    private List<ConfigurationInformation> configurationInformation;
}
