package br.com.zup.refund.service.impl;

import br.com.zup.refund.model.TimeSheet;
import br.com.zup.refund.repository.TimeSheetRepository;
import org.springframework.stereotype.Service;

import br.com.zup.refund.model.Employee;
import br.com.zup.refund.model.TimeSheetApproval;
import br.com.zup.refund.repository.TimeSheetApprovalRepository;

@Service
public class TimeSheetApprovalService {
    
    private TimeSheetApprovalRepository timeSheetApprovalRepository;
    private TimeSheetRepository timeSheetRepository;
    
    public TimeSheetApprovalService(TimeSheetApprovalRepository timeSheetApprovalRepository,
                                    TimeSheetRepository timeSheetRepository) {
        this.timeSheetApprovalRepository = timeSheetApprovalRepository;
        this.timeSheetRepository = timeSheetRepository;
    }

    public void approve(TimeSheetApproval timeSheetApproval, Employee employee) {
        timeSheetApproval.setEmployee(employee);
        TimeSheet timeSheetFound = timeSheetRepository.findOne(timeSheetApproval.getTimeSheet().getTimeSheetId());
        timeSheetApproval.setTimeSheet(timeSheetFound);
        timeSheetFound.setTimeSheetApproval(timeSheetApprovalRepository.save(timeSheetApproval));
        timeSheetRepository.save(timeSheetFound);
    }
}
