package net.java.springboot.service;
//CompanyOrgServiceImpl.java


import net.java.springboot.dto.CompanyOrgDTO;
import net.java.springboot.entity.CompanyOrg;
import net.java.springboot.repository.CompanyOrgRepository;
import net.java.springboot.service.CompanyOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyOrgServiceImpl implements CompanyOrgService {

 private final CompanyOrgRepository companyOrgRepository;

 @Autowired
 public CompanyOrgServiceImpl(CompanyOrgRepository companyOrgRepository) {
     this.companyOrgRepository = companyOrgRepository;
 }

 @Override
 public CompanyOrgDTO createCompanyOrg(CompanyOrgDTO companyOrgDTO) {
     CompanyOrg companyOrg = convertToEntity(companyOrgDTO);
     companyOrg = companyOrgRepository.save(companyOrg);
     return convertToDTO(companyOrg);
 }

 @Override
 public CompanyOrgDTO getCompanyOrgById(Long companyId) {
     CompanyOrg companyOrg = companyOrgRepository.findById(companyId)
             .orElseThrow(() -> new RuntimeException("CompanyOrg not found"));
     return convertToDTO(companyOrg);
 }

 @Override
 public List<CompanyOrgDTO> getAllCompanyOrgs() {
     return companyOrgRepository.findAll()
             .stream()
             .map(this::convertToDTO)
             .collect(Collectors.toList());
 }

 @Override
 public CompanyOrgDTO updateCompanyOrg(Long companyId, CompanyOrgDTO companyOrgDTO) {
     CompanyOrg companyOrg = companyOrgRepository.findById(companyId)
             .orElseThrow(() -> new RuntimeException("CompanyOrg not found"));
     companyOrg.setCompanyName(companyOrgDTO.getCompanyName());
     companyOrg.setProjectId(companyOrgDTO.getProjectId());
     companyOrg.setLocation(companyOrgDTO.getLocation());
     return convertToDTO(companyOrgRepository.save(companyOrg));
 }

 @Override
 public void deleteCompanyOrg(Long companyId) {
     CompanyOrg companyOrg = companyOrgRepository.findById(companyId)
             .orElseThrow(() -> new RuntimeException("CompanyOrg not found"));
     companyOrgRepository.delete(companyOrg);
 }

 private CompanyOrgDTO convertToDTO(CompanyOrg companyOrg) {
     CompanyOrgDTO dto = new CompanyOrgDTO();
     dto.setCompanyId(companyOrg.getCompanyId());
     dto.setCompanyName(companyOrg.getCompanyName());
     dto.setProjectId(companyOrg.getProjectId());
     dto.setLocation(companyOrg.getLocation());
     return dto;
 }

 private CompanyOrg convertToEntity(CompanyOrgDTO dto) {
     CompanyOrg companyOrg = new CompanyOrg();
     companyOrg.setCompanyId(dto.getCompanyId());
     companyOrg.setCompanyName(dto.getCompanyName());
     companyOrg.setProjectId(dto.getProjectId());
     companyOrg.setLocation(dto.getLocation());
     return companyOrg;
 }
}


