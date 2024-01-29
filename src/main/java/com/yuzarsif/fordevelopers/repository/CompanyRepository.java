package com.yuzarsif.fordevelopers.repository;

import com.yuzarsif.fordevelopers.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, String> {

    Optional<Company> findByCompanyName(String companyName);

    Optional<Company> findByPhoneNumber(String phoneNumber);
}
