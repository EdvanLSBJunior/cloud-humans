package com.example.cloudhuman.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EducationLevel {

    private boolean noEducation;
    private boolean highSchool;
    private boolean bachelorsDegreeOrHigh;

    public EducationLevel(String value) {
        if (value.equals("no_education")) {
            this.noEducation = true;
        } else if (value.equals("high_school")) {
            this.highSchool = true;
        } else if (value.equals("bachelors_degree_or_high")) {
            this.bachelorsDegreeOrHigh = true;
        } else {
            throw new IllegalArgumentException("Invalid value for EducationLevel: " + value);
        }
    }
}
