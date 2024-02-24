package com.example.cloudhuman.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EducationLevel {

    @JsonProperty("no_education")
    private boolean  noEducation;
    @JsonProperty("high_school")
    private boolean  highSchool;
    @JsonProperty("bachelors_degree_or_high")
    private boolean bachelorsDegreeOrHigh;

    public EducationLevel(String value) {
        if (value.equals("no_education")) {
            this.noEducation = true;
        } else if (value.equals("high_school")) {
            this.highSchool = true;
        } else if (value.equals("bachelors_degree_or_high")) {
            this.bachelorsDegreeOrHigh = true;
        } else {
            throw new IllegalArgumentException("Valor inválido para EducationLevel: " + value);
        }
    }
}
