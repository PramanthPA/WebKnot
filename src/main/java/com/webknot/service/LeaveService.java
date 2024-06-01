package com.webknot.service;

import com.webknot.dto.LeaveDTO;
import com.webknot.entity.Leave;

import java.util.List;

public interface LeaveService {
    Leave applyLeave(LeaveDTO leaveDTO);
    List<Leave> getLeavesByEmployee(Long employeeId);
    long getDaysSpentOnProject(Long employeeId, Long projectId);
}
