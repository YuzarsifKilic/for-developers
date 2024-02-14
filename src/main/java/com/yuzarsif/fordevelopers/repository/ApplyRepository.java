package com.yuzarsif.fordevelopers.repository;

import com.yuzarsif.fordevelopers.model.Apply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ApplyRepository extends JpaRepository<Apply, Long> {

    List<Apply> findAllByEmployeeId(String employeeId);

    List<Apply> findAllByAdvertisement_Company_Id(String companyId);

    List<Apply> findAllByAdvertisement_Id(Long advertisementId);

    Optional<Apply> findByEmployee_IdAndAdvertisement_Id(String employeeId, Long advertisementId);
}
