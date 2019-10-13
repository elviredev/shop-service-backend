package com.elviredev.dao;

import com.elviredev.entities.CoachedAppli;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface CoachedAppliRepository extends MongoRepository<CoachedAppli, String> {
    @RestResource(path="/coachedApplisByKeyword")
    List<CoachedAppli> findByAppliNameContains(@Param("kw") String kw); //http://localhost:8087/coachedApplis/search/coachedApplisByKeyword?kw=AP
}
