package com.elviredev.dao;

import com.elviredev.entities.ContentAppli;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ContentAppliRepository extends MongoRepository<ContentAppli, String> {
}
