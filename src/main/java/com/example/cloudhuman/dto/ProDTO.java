package com.example.cloudhuman.dto;

import com.example.cloudhuman.enums.EducationLevel;
import com.example.cloudhuman.models.PastExperiences;
import com.example.cloudhuman.models.InternetTest;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProDTO {
    private int age;
    private EducationLevel educationLevel;
    private PastExperiences pastExperiences;
    private InternetTest internetTest;
    @DecimalMin(value = "0", inclusive = true)
    @DecimalMax(value = "1", inclusive = true)
    private float writingScore;
    private String referralCode;
}
