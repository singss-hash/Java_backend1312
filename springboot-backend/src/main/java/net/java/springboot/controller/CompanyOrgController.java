package net.java.springboot.controller;

//CompanyOrgController.java


import net.java.springboot.dto.CompanyOrgDTO;
import net.java.springboot.service.CompanyOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companyorgs")
@CrossOrigin(origins = {"http://your-allowed-origin.com"}) // Replace with specific allowed origins
public class CompanyOrgController {

 private final CompanyOrgService companyOrgService;

 @Autowired
 public CompanyOrgController(CompanyOrgService companyOrgService) {
     this.companyOrgService = companyOrgService;
 }

 @PostMapping
 public ResponseEntity<CompanyOrgDTO> createCompanyOrg(@RequestBody CompanyOrgDTO companyOrgDTO) {
     CompanyOrgDTO createdCompanyOrg = companyOrgService.createCompanyOrg(companyOrgDTO);
     return ResponseEntity.ok(createdCompanyOrg);
 }

 @GetMapping("/{companyId}")
 public ResponseEntity<CompanyOrgDTO> getCompanyOrgById(@PathVariable Long companyId) {
     CompanyOrgDTO companyOrg = companyOrgService.getCompanyOrgById(companyId);
     return ResponseEntity.ok(companyOrg);
 }

 @GetMapping
 public ResponseEntity<List<CompanyOrgDTO>> getAllCompanyOrgs() {
     List<CompanyOrgDTO> companyOrgs = companyOrgService.getAllCompanyOrgs();
     return ResponseEntity.ok(companyOrgs);
 }

 @PutMapping("/{companyId}")
 public ResponseEntity<CompanyOrgDTO> updateCompanyOrg(@PathVariable Long companyId, @RequestBody CompanyOrgDTO companyOrgDTO) {
     CompanyOrgDTO updatedCompanyOrg = companyOrgService.updateCompanyOrg(companyId, companyOrgDTO);
     return ResponseEntity.ok(updatedCompanyOrg);
 }

 @DeleteMapping("/{companyId}")
 public ResponseEntity<Void> deleteCompanyOrg(@PathVariable Long companyId) {
     companyOrgService.deleteCompanyOrg(companyId);
     return ResponseEntity.noContent().build();
 }
}
