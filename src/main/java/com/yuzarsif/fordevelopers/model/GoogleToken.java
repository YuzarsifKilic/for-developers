package com.yuzarsif.fordevelopers.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "GoogleToken")
public class GoogleToken {

    @Id
    private String userId;
    private String token;
    private Date createdDate;
}
