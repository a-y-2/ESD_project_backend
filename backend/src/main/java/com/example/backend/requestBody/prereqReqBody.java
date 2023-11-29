package com.example.backend.requestBody;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class prereqReqBody {

    @JsonProperty("course_id")
    private Long prereqId;

    @JsonProperty("description")
    private String description;

}