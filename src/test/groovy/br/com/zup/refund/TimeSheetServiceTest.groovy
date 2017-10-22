package br.com.zup.refund

import br.com.zup.refund.model.*
import br.com.zup.refund.model.enuns.EmployeeType
import br.com.zup.refund.repository.ConfigurationInformationRepository
import br.com.zup.refund.repository.TimeSheetRepository
import br.com.zup.refund.service.ConfigurationInformationService
import br.com.zup.refund.service.TimeSheetService
import br.com.zup.refund.service.impl.ConfigurationInformationServiceImpl
import br.com.zup.refund.service.impl.TimeSheetServiceImpl
import spock.lang.Specification

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class TimeSheetServiceTest extends Specification {

    TimeSheetRepository timeSheetRepository = Mock(TimeSheetRepository)
    TimeSheetService timeSheetService = new TimeSheetServiceImpl(timeSheetRepository)

    def timeSheet = buildTimeSheet()

    def "should get configurations"(){
        timeSheet = buildTimeSheet()

        when:
        def savedTimeSheet = timeSheetService.create(timeSheet)

        then:
        1 * timeSheetRepository.save(timeSheet) >> timeSheet
        savedTimeSheet == timeSheet
    }

    def buildTimeSheet(){
        def customer = Customer.builder().customerId(1).name("customer").build()
        def caseTaskEvent = CaseTaskEvent.builder().caseTaskEventId(1).name("caseTaskEvent").build()
        def serviceItem = ServiceItem.builder().itemId(1).description("description").build()
        def subsidiary = Subsidiary.builder().subsidiaryId(1).name("name").build()
        def clasz = Clasz.builder().classId(1).name("class").build()
        def location = Location.builder().locationId(1).name("location").build()
        def department = Department.builder().departmentId(1).name("department").build()
        def employee = Employee.builder().id(1L).name("name").email("test@mymail").password("pass").build()

        def primaryInformation = PrimaryInformation.builder()
            .id(1L)
            .date(LocalDate.now())
            .startTime(LocalDateTime.now())
            .endTime(LocalDateTime.now().plusHours(1))
            .duration(LocalTime.now().plusHours(1))
            .customer(customer)
            .billable(true)
            .memo("blahblahblah")
            .serviceItem(serviceItem)
            .caseTaskEvent(caseTaskEvent)
            .employee(employee)
            .build()

        def classification = Classification.builder()
            .id(1L)
            .subsidiary(subsidiary)
            .clasz(clasz)
            .location(location)
            .department(department)
            .caseTaskEvent(caseTaskEvent)
            .build()

        def timeSheetApproval = TimeSheetApproval.builder()
            .id(1L)
            .employee(employee)
            .status(1L)
            .memo("blahblahblah")
            .build()


        return TimeSheet.builder()
                .timeSheetId(1L)
                .primaryInformation(primaryInformation)
                .classification(classification)
                .employee(employee)
                .timeSheetApproval(timeSheetApproval)
                .build()
    }
}
