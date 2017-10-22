package br.com.zup.refund.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Subsidiary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subsidiaryId;

    private String name;

    @OneToMany(mappedBy = "subsidiary")
    List<Classification> classifications;

    @ManyToMany(mappedBy = "subsidiary")
    private List<ConfigurationInformation> configurationInformation;
}
