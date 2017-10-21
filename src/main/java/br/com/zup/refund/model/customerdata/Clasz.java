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
public class Clasz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long classId;

    private String name;

    @OneToMany(mappedBy = "clasz")
    List<Classification> classifications;
}
