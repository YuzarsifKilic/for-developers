package com.yuzarsif.fordevelopers.repository;

import com.yuzarsif.fordevelopers.model.GoogleToken;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface GoogleTokenRepository extends MongoRepository<GoogleToken, String> {

    List<GoogleToken> findTokensByCreatedDateBefore(Date date);
}
