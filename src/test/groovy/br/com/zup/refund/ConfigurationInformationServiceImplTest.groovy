package br.com.zup.refund

import br.com.zup.refund.model.ConfigurationInformation
import br.com.zup.refund.model.customerdata.CaseTaskEvent
import br.com.zup.refund.model.customerdata.Clasz
import br.com.zup.refund.model.customerdata.Customer
import br.com.zup.refund.model.customerdata.Department
import br.com.zup.refund.model.customerdata.Location
import br.com.zup.refund.model.customerdata.ServiceItem
import br.com.zup.refund.model.customerdata.Subsidiary
import br.com.zup.refund.repository.ConfigurationInformationRepository
import br.com.zup.refund.service.ConfigurationInformationService
import br.com.zup.refund.service.impl.ConfigurationInformationServiceImpl
import spock.lang.Specification


class ConfigurationInformationServiceImplTest extends Specification {

    ConfigurationInformationRepository configurationInformationRepository = Mock(ConfigurationInformationRepository)
    ConfigurationInformationService configurationInformationService = new ConfigurationInformationServiceImpl(configurationInformationRepository)

    def configurations

    def "should get configurations"(){
        configurations = buildConfigurationItems()

        when:
        def configurationsFound = configurationInformationService.getConfigurations()

        then:
        1 * configurationInformationRepository.findAll() >> configurations
        configurationsFound == configurations.get(0)
    }

    List<ConfigurationInformation> buildConfigurationItems() {
        def customer = Arrays.asList(Customer.builder().customerId(1).name("customer").build())
        def caseTaskEvent = Arrays.asList(CaseTaskEvent.builder().caseTaskEventId(1).name("caseTaskEvent").build())
        def serviceItem = Arrays.asList(ServiceItem.builder().itemId(1).description("description").build())
        def subsidiary = Arrays.asList(Subsidiary.builder().subsidiaryId(1).name("name").build())
        def clasz = Arrays.asList(Clasz.builder().classId(1).name("class").build())
        def location = Arrays.asList(Location.builder().locationId(1).name("location").build())
        def department = Arrays.asList(Department.builder().departmentId(1).name("department").build())

        def config = ConfigurationInformation.builder()
            .id(1)
            .customer(customer)
            .caseTaskEvent(caseTaskEvent)
            .serviceItem(serviceItem)
            .subsidiary(subsidiary)
            .clasz(clasz)
            .location(location)
            .department(department)
            .build()

        return Arrays.asList(config)
    }

}
