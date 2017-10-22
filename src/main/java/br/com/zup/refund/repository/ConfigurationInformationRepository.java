package br.com.zup.refund.repository;

import br.com.zup.refund.model.ConfigurationInformation;
import br.com.zup.refund.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationInformationRepository extends JpaRepository<ConfigurationInformation, Long>{

}
