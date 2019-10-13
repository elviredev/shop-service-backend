package com.elviredev.dao;

import com.elviredev.entities.ContentAppli;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface ContentAppliRepository extends MongoRepository<ContentAppli, String> {
    @RestResource(path = "/selectedContents")
    List<ContentAppli> findBySelectedIsTrue();
}
