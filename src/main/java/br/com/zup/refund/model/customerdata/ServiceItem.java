package br.com.zup.refund.model.customerdata;

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
public class ServiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;

    private String description;

    @OneToMany(mappedBy = "serviceItem")
    private List<PrimaryInformation> primaryInformations;
}
