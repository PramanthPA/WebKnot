package com.webknot.service;

import com.webknot.dto.LeaveDTO;
import com.webknot.entity.Employee;
import com.webknot.entity.Leave;
import com.webknot.entity.Project;
import com.webknot.repository.EmployeeRepository;
import com.webknot.repository.LeaveRepository;
import com.webknot.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    private LeaveRepository leaveRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Leave applyLeave(LeaveDTO leaveDTO) {
        Employee employee = employeeRepository.findById(leaveDTO.getEmployeeId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee ID"));

        Leave leave = new Leave();
        leave.setEmployee(employee);
        leave.setLeaveDate(leaveDTO.getLeaveDate());

        return leaveRepository.save(leave);
    }

    @Override
    public List<Leave> getLeavesByEmployee(Long employeeId) {
        return leaveRepository.findByEmployeeId(employeeId);
    }

    @Override
    public long getDaysSpentOnProject(Long employeeId, Long projectId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee ID"));
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid project ID"));

        LocalDate startDate = project.getStartDate();
        LocalDate endDate = project.getEndDate() != null ? project.getEndDate() : LocalDate.now();

        Set<LocalDate> leaveDates = leaveRepository.findByEmployeeId(employeeId).stream()
                .map(Leave::getLeaveDate)
                .collect(Collectors.toSet());

        long daysSpent = startDate.datesUntil(endDate.plusDays(1))
                .filter(date -> !leaveDates.contains(date))
                .filter(date -> !date.getDayOfWeek().equals(DayOfWeek.SATURDAY) && !date.getDayOfWeek().equals(DayOfWeek.SUNDAY))
                .count();

        return daysSpent;
    }
}
