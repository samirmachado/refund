package br.com.zup.refund.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.refund.model.TimeSheetApproval;

public interface TimeSheetApprovalRepository extends JpaRepository<TimeSheetApproval, Long> {

}
