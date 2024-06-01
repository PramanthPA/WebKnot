package com.webknot.controller;

import com.webknot.dto.LeaveDTO;
import com.webknot.entity.Leave;
import com.webknot.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leaves")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @PostMapping("/apply")
    public ResponseEntity<Leave> applyLeave(@RequestBody LeaveDTO leaveDTO) {
        Leave leave = leaveService.applyLeave(leaveDTO);
        return ResponseEntity.ok(leave);
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<Leave>> getLeavesByEmployee(@PathVariable Long employeeId) {
        List<Leave> leaves = leaveService.getLeavesByEmployee(employeeId);
        return ResponseEntity.ok(leaves);
    }

    @GetMapping("/daysSpent")
    public ResponseEntity<Long> getDaysSpentOnProject(@RequestParam Long employeeId, @RequestParam Long projectId) {
        long daysSpent = leaveService.getDaysSpentOnProject(employeeId, projectId);
        return ResponseEntity.ok(daysSpent);
    }
}
