package br.com.zup.refund.service.impl;

import org.springframework.stereotype.Service;

import br.com.zup.refund.model.Employee;
import br.com.zup.refund.model.TimeSheetApproval;
import br.com.zup.refund.repository.TimeSheetApprovalRepository;

@Service
public class TimeSheetApprovalService {
    
    private TimeSheetApprovalRepository timeSheetApprovalRepository;
    
    public TimeSheetApprovalService(TimeSheetApprovalRepository timeSheetApprovalRepository) {
        this.timeSheetApprovalRepository = timeSheetApprovalRepository;
    }

    public void approve(TimeSheetApproval timeSheetApproval, Employee employee) {
        timeSheetApproval.setEmployee(employee);
        timeSheetApprovalRepository.save(timeSheetApproval);
    }
}
