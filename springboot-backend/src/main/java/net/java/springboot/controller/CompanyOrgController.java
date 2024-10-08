package net.java.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.java.springboot.dto.CompanyOrgDTO;
import net.java.springboot.service.CompanyOrgService;

//CompanyOrgController.java


import net.java.springboot.service.CompanyOrgServiceImpl;

@RestController
@RequestMapping("/api/companyorgs")
@CrossOrigin(origins = {"http://localhost:4200"}) 
public class CompanyOrgController {
	@Autowired
 private final CompanyOrgService companyOrgService;


 public CompanyOrgController(CompanyOrgServiceImpl companyOrgService) {
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
