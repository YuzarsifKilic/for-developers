package com.yuzarsif.fordevelopers.controller;

import com.yuzarsif.fordevelopers.dto.CompanyDto;
import com.yuzarsif.fordevelopers.dto.request.CreateCompanyRequest;
import com.yuzarsif.fordevelopers.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<Void> saveCompany(@RequestBody CreateCompanyRequest request) {
        companyService.saveCompany(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDto> findCompanyById(@PathVariable String id) {
        return ResponseEntity.ok(companyService.findCompanyById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        companyService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
