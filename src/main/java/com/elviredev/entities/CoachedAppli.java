package com.elviredev.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Document
@Data @AllArgsConstructor @NoArgsConstructor
public class CoachedAppli implements Serializable {
    @Id
    private String idAppli;
    private String appliName;
    @DBRef
    private Collection<ContentAppli> contentApplis = new ArrayList<>();

    @Override
    public String toString() {
        return "CoachedAppli{" +
                "id='" + idAppli + '\'' +
                ", appliName='" + appliName + '\'' +
                '}';
    }
}
