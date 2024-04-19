package com.yuzarsif.fordevelopers.repository;

import com.yuzarsif.fordevelopers.model.GithubToken;
import com.yuzarsif.fordevelopers.model.GoogleToken;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface GithubTokenRepository extends MongoRepository<GithubToken, String> {

    List<GithubToken> findTokensByCreatedDateBefore(Date date);
}
