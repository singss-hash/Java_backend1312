package net.java.springboot.service;

//CompanyOrgService.java


import net.java.springboot.dto.CompanyOrgDTO;
import java.util.List;

public interface CompanyOrgService {
 CompanyOrgDTO createCompanyOrg(CompanyOrgDTO companyOrgDTO);
 CompanyOrgDTO getCompanyOrgById(Long companyId);
 List<CompanyOrgDTO> getAllCompanyOrgs();
 CompanyOrgDTO updateCompanyOrg(Long companyId, CompanyOrgDTO companyOrgDTO);
 void deleteCompanyOrg(Long companyId);
}

