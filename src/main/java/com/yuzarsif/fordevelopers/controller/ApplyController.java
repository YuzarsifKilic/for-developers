package com.yuzarsif.fordevelopers.controller;

import com.yuzarsif.fordevelopers.dto.CompanyApplyDto;
import com.yuzarsif.fordevelopers.dto.request.CreateApplyRequest;
import com.yuzarsif.fordevelopers.dto.EmployeeApplyDto;
import com.yuzarsif.fordevelopers.service.ApplyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apply")
public class ApplyController {

    private final ApplyService applyService;

    public ApplyController(ApplyService applyService) {
        this.applyService = applyService;
    }

    @PostMapping
    public ResponseEntity<Void> saveApply(@RequestBody CreateApplyRequest request) {
        applyService.saveApply(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<EmployeeApplyDto>> findAllByEmployeeId(@PathVariable String employeeId) {
        return ResponseEntity.ok(applyService.findAllByEmployeeId(employeeId));
    }

    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<CompanyApplyDto>> findAllByCompanyId(@PathVariable String companyId) {
        return ResponseEntity.ok(applyService.findAllByCompanyId(companyId));
    }
}
