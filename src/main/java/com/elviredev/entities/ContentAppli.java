package com.elviredev.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import java.io.Serializable;

@Document
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class ContentAppli implements Serializable {
    @Id
    private String idContent;
    private String contentName;
    private boolean selected;
    @DBRef
    private CoachedAppli coachedAppli;
}
