package br.com.zup.refund.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.refund.model.Employee;
import br.com.zup.refund.model.TimeSheet;
import br.com.zup.refund.model.TimeSheetApproval;
import br.com.zup.refund.model.to.TimeSheetTO;
import br.com.zup.refund.service.impl.TimeSheetApprovalService;
import br.com.zup.refund.service.impl.TimeSheetService;
import br.com.zup.refund.session.Session;

@RestController
public class ReportController extends MainController{
    
    private TimeSheetApprovalService timeSheetApprovalService;
    private Session session;
    private TimeSheetService timeSheetService;

    public ReportController(TimeSheetApprovalService timeSheetApprovalService, Session session, TimeSheetService timeSheetService) {
        this.timeSheetApprovalService = timeSheetApprovalService;
        this.session = session;
        this.timeSheetService = timeSheetService;
    }
    
    @GetMapping("/pendents-timesheets")
    public ResponseEntity<?> pendingTimeSheets(HttpServletRequest httpServletRequest){
        Employee employee = session.getLoggedEmployee(httpServletRequest.getHeader("token"));
        List<TimeSheet> timeSheets = timeSheetService.getPendingTimeSheetsOf(employee);
        return responseOk(new TimeSheetTO().mapList(timeSheets));
    }

    @PostMapping("/approve")
    public ResponseEntity<?> approve(@RequestBody TimeSheetApproval timeSheetApproval, HttpServletRequest httpServletRequest){
        Employee employee = session.getLoggedEmployee(httpServletRequest.getHeader("token"));
        timeSheetApprovalService.approve(timeSheetApproval, employee);
        return responseOk();
    }
}
