package br.com.zup.refund.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.zup.refund.model.Employee;
import br.com.zup.refund.model.TimeSheet;
import br.com.zup.refund.repository.TimeSheetRepository;

@Service
public class TimeSheetService {

    private TimeSheetRepository timeSheetRepository;
    
    public TimeSheetService(TimeSheetRepository timeSheetRepository) {
        this.timeSheetRepository = timeSheetRepository;
    }

    public List<TimeSheet> getPendingTimeSheetsOfManager(Employee employee) {
        return timeSheetRepository.findTimeSheetsOfManager(employee.getId());
    }

    public List<TimeSheet> listByEmployee(Employee employee) {
        return timeSheetRepository.findByEmployee(employee);
    }
}
