package com.yuzarsif.fordevelopers.repository;

import com.yuzarsif.fordevelopers.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
