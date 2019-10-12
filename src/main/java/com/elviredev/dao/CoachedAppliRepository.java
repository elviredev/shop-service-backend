package com.elviredev.dao;

import com.elviredev.entities.CoachedAppli;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CoachedAppliRepository extends MongoRepository<CoachedAppli, String> {
}
