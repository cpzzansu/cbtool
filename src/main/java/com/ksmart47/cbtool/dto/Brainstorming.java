package com.ksmart47.cbtool.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Brainstorming {
    private final String id;
    private final String htmlContent;

    @JsonCreator
    public Brainstorming(
            @JsonProperty("id") String id,
            @JsonProperty("htmlContent") String htmlContent) {
        this.id = id;
        this.htmlContent = htmlContent;
    }
}
