package br.com.zup.refund.service.impl;

import br.com.zup.refund.model.Employee;
import br.com.zup.refund.model.TimeSheet;
import br.com.zup.refund.repository.EmployeeRepository;
import br.com.zup.refund.repository.TimeSheetRepository;
import br.com.zup.refund.service.TimeSheetService;
import org.springframework.stereotype.Service;

@Service
public class TimeSheetServiceImpl implements TimeSheetService {

    private TimeSheetRepository timeSheetRepository;
    private EmployeeRepository employeeRepository;

    public TimeSheetServiceImpl(TimeSheetRepository timeSheetRepository, EmployeeRepository employeeRepository){
        this.timeSheetRepository = timeSheetRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public TimeSheet create(TimeSheet timeSheet) {
        Employee employeeFound = employeeRepository.findOne(timeSheet.getPrimaryInformation().getEmployee().getId());
        timeSheet.getPrimaryInformation().setEmployee(employeeFound);
        Long timeSheetId = timeSheetRepository.save(timeSheet).getTimeSheetId();
        return timeSheetRepository.findOne(timeSheetId);
    }
}
