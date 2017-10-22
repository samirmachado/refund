package br.com.zup.refund.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.refund.model.TimeSheet;
import br.com.zup.refund.model.to.TimeSheetTO;
import br.com.zup.refund.service.TimeSheetService;

@RestController
public class TimeSheetController extends MainController{

    private TimeSheetService timeSheetService;

    public TimeSheetController(TimeSheetService timeSheetService){
        this.timeSheetService = timeSheetService;
    }

    @PostMapping("/timesheets")
    public ResponseEntity<?> create(TimeSheet timeSheet){
        TimeSheetTO timeSheetTO = new TimeSheetTO().map(timeSheetService.create(timeSheet));
        return responseOk(timeSheetTO);
    }
}
