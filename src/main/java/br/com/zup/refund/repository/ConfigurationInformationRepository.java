package br.com.zup.refund.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.refund.model.ConfigurationInformation;

@Repository
public interface ConfigurationInformationRepository extends JpaRepository<ConfigurationInformation, Long>{

}
