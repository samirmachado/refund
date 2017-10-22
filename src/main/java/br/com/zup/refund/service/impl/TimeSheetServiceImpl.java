package br.com.zup.refund.service.impl;

import br.com.zup.refund.model.TimeSheet;
import br.com.zup.refund.repository.TimeSheetRepository;
import br.com.zup.refund.service.TimeSheetService;
import org.springframework.stereotype.Service;

@Service
public class TimeSheetServiceImpl implements TimeSheetService {

    private TimeSheetRepository timeSheetRepository;

    public TimeSheetServiceImpl(TimeSheetRepository timeSheetRepository){
        this.timeSheetRepository = timeSheetRepository;
    }

    @Override
    public TimeSheet create(TimeSheet timeSheet) {
        return timeSheetRepository.save(timeSheet);
    }
}
