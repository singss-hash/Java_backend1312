package net.java.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.java.springboot.entity.CompanyOrg;

public interface CompanyOrgRepository extends JpaRepository<CompanyOrg,Long> {

}
