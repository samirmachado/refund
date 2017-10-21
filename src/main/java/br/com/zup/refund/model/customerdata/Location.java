package br.com.zup.refund.model.customerdata;

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
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long locationId;

    private String name;

    @OneToMany(mappedBy = "location")
    List<Classification> classifications;
}
