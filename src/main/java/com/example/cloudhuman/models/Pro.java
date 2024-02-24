package com.example.cloudhuman.models;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pro {

    @NotNull
    private int age;
    @NotBlank
    private EducationLevel educationLevel;
    @NotBlank
    private PastExperiences pastExperiences;
    @NotNull
    private InternetTest internetTest;

    @DecimalMin(value = "0")
    @DecimalMax(value = "1")
    private float writingScore;
    private String referralCode;
}
