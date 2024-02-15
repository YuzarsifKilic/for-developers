package com.yuzarsif.fordevelopers.repository;

import com.yuzarsif.fordevelopers.model.Advertisement;
import com.yuzarsif.fordevelopers.model.JobTitle;
import com.yuzarsif.fordevelopers.model.WorkType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

    List<Advertisement> findAllByCompany_Id(String companyId);

    List<Advertisement> findTop20ByOrderByViewCountDesc();

    List<Advertisement> findByAdvertisementTitleContainingIgnoreCase(String title);

    List<Advertisement> findByAdvertisementTitleContainingIgnoreCaseAndJobTitleIn(String advertisementTitle, Collection<JobTitle> jobTitles);
    List<Advertisement> findByAdvertisementTitleContainingIgnoreCaseAndWorkTypeIn(String advertisementTitle, Collection<WorkType> workTypes);
    List<Advertisement> findByAdvertisementTitleContainingIgnoreCaseAndJobTitleInAndWorkTypeIn(String advertisementTitle, Collection<JobTitle> jobTitle, Collection<WorkType> workTypes);
}
