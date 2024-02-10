package com.yuzarsif.fordevelopers.service;

import com.yuzarsif.fordevelopers.model.Apply;
import com.yuzarsif.fordevelopers.repository.ApplyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyManager {

    private final ApplyRepository repository;

    public ApplyManager(ApplyRepository repository) {
        this.repository = repository;
    }

    public void deleteByAdvertisementId(Long advertisementId) {
        List<Apply> allByAdvertisementId = repository.findAllByAdvertisement_Id(advertisementId);

        repository.deleteAll(allByAdvertisementId);
    }
}
