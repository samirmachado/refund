package br.com.zup.refund.model.customerdata;

import br.com.zup.refund.model.ConfigurationInformation;
import br.com.zup.refund.model.timesheet.Classification;
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
public class Subsidiary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subsidiaryId;

    private String name;

    @OneToMany(mappedBy = "subsidiary")
    List<Classification> classifications;

    @OneToMany(mappedBy = "subsidiary")
    private List<ConfigurationInformation> configurationInformation;
}
